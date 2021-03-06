package techcoder.aman.bucketdrops;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import techcoder.aman.bucketdrops.beans.Drop;

/**
 * Created by Aman on 27/07/16.
 */





public class DialogAdd extends DialogFragment {

    private ImageButton mBtnClose;
    private EditText mInputWhat;
    private DatePicker mInputWhen;
    private Button mBtnAdd;

private View.OnClickListener mBtnClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id)
        {
            case R.id.btn_add_it:
                addAction();
                break;
        }
        dismiss();
    }
};

    private void addAction() {

        String what = mInputWhat.getText().toString();
        long now = System.currentTimeMillis();
        RealmConfiguration configuration = new RealmConfiguration.Builder(getActivity()).build();
        Realm.setDefaultConfiguration(configuration);
        Realm realm= Realm.getDefaultInstance();

        Drop drop = new Drop(what,now,0,false);
        realm.copyToRealm(drop);
        realm.beginTransaction();
        realm.copyToRealm(drop);
        realm.commitTransaction();
        realm.close();

    }


    public DialogAdd() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_add, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mBtnClose = (ImageButton) view.findViewById(R.id.btn_close);
        mBtnAdd = (Button) view.findViewById(R.id.btn_add);
        mInputWhat = (EditText) view.findViewById(R.id.et_drop);
        mInputWhen = (DatePicker) view.findViewById(R.id.bpv_date);
        mBtnClose.setOnClickListener(mBtnClickListener);
        mBtnAdd.setOnClickListener(mBtnClickListener);

}
}

package com.example.quanlycauthu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvcauthu;
    ArrayList<CauThu> listcauthu = new ArrayList<>();
    DataBaseCauThu db;
    int id;
    ListViewCauThu_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvcauthu = findViewById(R.id.ListViewCauThu);
        db = new DataBaseCauThu(getApplicationContext());
        String insert1 = "INSERT INTO CAUTHU(TENCT,SOAO,DIACHI) VALUES ('Lương Xuân Trường',7,'Hoàng Anh Gia Lai')";
        String insert2 = "INSERT INTO CAUTHU(TENCT,SOAO,DIACHI) VALUES ('Nguyễn Văn Toàn',9,'Hoàng Anh Gia Lai')";
        String insert3 = "INSERT INTO CAUTHU(TENCT,SOAO,DIACHI) VALUES ('Nguyễn Công Phượng',10,'Hoàng Anh Gia Lai')";
        String insert4 = "INSERT INTO CAUTHU(TENCT,SOAO,DIACHI) VALUES ('Nguyễn Quang Hải',23,'CLB Hà Nội')";
        String insert5 = "INSERT INTO CAUTHU(TENCT,SOAO,DIACHI) VALUES ('Bùi Tiến Dũng',1,'FLC Thanh Hóa')";
        String insert6 = "INSERT INTO CAUTHU(TENCT,SOAO,DIACHI) VALUES ('Vũ Văn Thanh',17,'Hoàng Anh Gia Lai')";

        db.excutequery(insert1);
        db.excutequery(insert2);
        db.excutequery(insert3);
        db.excutequery(insert4);
        db.excutequery(insert5);
        db.excutequery(insert6);

        listcauthu = db.danhSachCauThu();
        int id = listcauthu.get(0).getId();
        if(listcauthu.isEmpty())
        {
        }
        else
        {
            adapter = new ListViewCauThu_Adapter(getApplicationContext(),R.layout.listview_cauthu_row_custom,listcauthu);
            lvcauthu.setAdapter(adapter);
            registerForContextMenu(lvcauthu);
        }


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.quan_ly_cauthu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        id = listcauthu.get(info.position).getId();
        switch (item.getItemId())
        {
            case R.id.suacauthu:
//                Intent capnhat = new Intent(getApplicationContext(),CapNhatCauThu.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("CauThu",listcauthu.get(info.position));
//                capnhat.putExtra("ThongTin",bundle);
//                startActivityForResult(capnhat,1113);
                break;
            case R.id.xoacauthu:
                db.XoaCauThu(id);
                listcauthu.remove(info.position);
                adapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1113 & resultCode == 1114)
        {
            listcauthu.clear();
            listcauthu.addAll(db.danhSachCauThu());
            adapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
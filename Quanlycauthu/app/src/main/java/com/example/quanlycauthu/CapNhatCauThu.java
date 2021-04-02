package com.example.quanlycauthu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CapNhatCauThu extends AppCompatActivity {
    EditText edtten,edtsoao,edtdiachi;
    Button btncapnhat,btndong;
    DataBaseCauThu db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap_nhat_cau_thu);
        db = new DataBaseCauThu(getApplicationContext());
        Bundle bundle = new Bundle();
        Intent get = getIntent();
        bundle = get.getBundleExtra("ThongTin");
        CauThu cauthu =(CauThu) bundle.getSerializable("CauThu");
        //getintent

        edtten = findViewById(R.id.edttenCauthu_capnhat);
        edtsoao = findViewById(R.id.edtsoAo_capnhat);
        edtdiachi =findViewById(R.id.edtDiaChi_capnhat);
        btncapnhat = findViewById(R.id.btnCapNhap);
        btndong = findViewById(R.id.btnDongCapNhat);




        edtten.setText(cauthu.getTen().toString());
        edtdiachi.setText(cauthu.getDiachi().toString());
        edtsoao.setText(cauthu.getSoao()+"");

        btndong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btncapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten,soao,diachi;
                ten = edtten.getText().toString();
                soao = edtsoao.getText().toString();
                diachi = edtdiachi.getText().toString();
                boolean check = db.CapNhatCauThu(new CauThu(cauthu.getId(),ten,Integer.parseInt(soao),diachi));
                if(check==true)
                {
                    Intent intent = new Intent();
                    Toast.makeText(CapNhatCauThu.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    setResult(1114,intent);
                    finish();
                }
                else
                {
                    Toast.makeText(CapNhatCauThu.this, "Thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
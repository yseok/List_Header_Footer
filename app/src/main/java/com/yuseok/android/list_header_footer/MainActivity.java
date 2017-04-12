package com.yuseok.android.list_header_footer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // listview, header, footer 참조 획득.
        ListView listview = (ListView)findViewById(R.id.listview1) ;
        final View header = getLayoutInflater().inflate(R.layout.listview_header, null, false) ;
        View footer = getLayoutInflater().inflate(R.layout.listview_footer, null, false) ;

        // listView에 header, footer 추가.
        listview.addHeaderView(header) ;
        listview.addFooterView(footer) ;

        // 데이터를 지정하지 않은 adapter 생성하여 listview에 지정.
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1) ;
        listview.setAdapter(adapter) ;

        Button addButton = (Button) footer.findViewById(R.id.add);
        addButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count ;

                // Adapter에서 현재 아이템 개수 얻어온 다음 아이템 추가.
                count = adapter.getCount() + 1 ;
                adapter.add("LIST" + Integer.toString(count)) ;

                // Header View의 "count" TextView에 아이템 개수 업데이트.
                TextView textView = (TextView) header.findViewById(R.id.count) ;
                textView.setText(Integer.toString(count)) ;
            }
        });
    }
}
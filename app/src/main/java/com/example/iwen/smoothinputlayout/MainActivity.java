package com.example.iwen.smoothinputlayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.iwen.smoothinputlayout.smooth.SmoothInputLayout;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_expression;
    private SmoothInputLayout smoothInputLayout;
    private RecyclerView recyclerView;
    private ExpressionAdapter expressionAdapter;

    private static final Integer[] expressionId = new Integer[]{R.drawable.brow_nh, R.drawable.brow_xh, R.drawable.brow_gx,
            R.drawable.brow_sx, R.drawable.brow_fn, R.drawable.brow_wl
            , R.drawable.brow_lh, R.drawable.brow_yw, R.drawable.brow_bs
            , R.drawable.brow_xh, R.drawable.brow_dx, R.drawable.brow_lw
            , R.drawable.brow_tkl, R.drawable.brow_tml, R.drawable.brow_zt
            , R.drawable.brow_fd, R.drawable.brow_gz, R.drawable.brow_zdsk};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        // 表情点击按钮
        iv_expression = findViewById(R.id.iv_expression);
        // smoothInputLayout自定义控件
        smoothInputLayout = findViewById(R.id.smooth_layout);

        recyclerView = findViewById(R.id.feag_emoji);
        // 表情适配器
        recyclerView.setLayoutManager(new GridLayoutManager(this, 6));
        iv_expression.setOnClickListener(this);

        List<Integer> ints =  Arrays.asList(expressionId);
        expressionAdapter = new ExpressionAdapter(ints);
        recyclerView.setAdapter(expressionAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_expression:
                smoothInputLayout.showInputPane(true);
                break;
        }
    }

    public static class ExpressionAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {

        public ExpressionAdapter(@Nullable List<Integer> data) {
            super(R.layout.adapter_expression, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Integer item) {
            ImageView view = helper.getView(R.id.iv_icon);
            view.setImageResource(item);
        }
    }

    public static class ExpressionBean {
        public String name;
        public int id;
    }

}

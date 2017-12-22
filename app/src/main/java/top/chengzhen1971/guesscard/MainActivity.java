package top.chengzhen1971.guesscard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //第二步，声明界面上的View（组件）
    ImageView iv_card_left,iv_card_center,iv_card_right;
    Button btn_restart;

    int cardLeftNumber,cardCenterNumber,cardRightNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //第一步，创建初始化方法
        initData();
        initView();

        //设置三张牌
        setCards();
    }

    void initData(){

    }

    void initView(){
        //第三步，拿到所有的View
        iv_card_left = findViewById(R.id.iv_card_left);
        iv_card_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCardLeft();
            }
        });

        iv_card_center = findViewById(R.id.iv_card_center);
        iv_card_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCardCenter();
            }
        });

        iv_card_right = findViewById(R.id.iv_card_right);
        iv_card_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCardRight();
            }
        });

        btn_restart=findViewById(R.id.btn_restart);
        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBtnRestart();
            }
        });
    }

    void clickCardLeft(){
        toast("卡左");
        showCard();
    }

    void clickCardCenter(){
        toast("卡中");
        showCard();
    }

    void clickCardRight(){
        toast("卡右");
        showCard();
    }

    void clickBtnRestart(){
        toast("按键");
    }

    void setCards(){
        Random r = new Random();
        //int整形(整数类型)，float浮点（小数）
        //赋值
        int luckCardNum = r.nextInt(3);

        if(luckCardNum == 0){
            cardLeftNumber = 0;
            cardCenterNumber = 1;
            cardRightNumber = 2;
        }

        if(luckCardNum == 1){
            cardLeftNumber = 1;
            cardCenterNumber = 0;
            cardRightNumber = 2;
        }

        if(luckCardNum == 2){
            cardLeftNumber = 1;
            cardCenterNumber = 2;
            cardRightNumber = 0;
        }
    }

    void showCard(){
        if(cardLeftNumber==0) {
            iv_card_left.setImageResource(R.drawable.card_a);
        }else if(cardLeftNumber==1){
            iv_card_left.setImageResource(R.drawable.card_2);
        }else{
            iv_card_left.setImageResource(R.drawable.card_3);
        }

        if(cardCenterNumber==0) {
            iv_card_center.setImageResource(R.drawable.card_a);
        }else if(cardCenterNumber==1){
            iv_card_center.setImageResource(R.drawable.card_2);
        }else{
            iv_card_center.setImageResource(R.drawable.card_3);
        }

        if(cardRightNumber==0) {
            iv_card_right.setImageResource(R.drawable.card_a);
        }else if(cardRightNumber==1){
            iv_card_right.setImageResource(R.drawable.card_2);
        }else{
            iv_card_right.setImageResource(R.drawable.card_3);
        }
    }

    void toast(String info){
        Toast.makeText(this,info,Toast.LENGTH_SHORT).show();
    }
}

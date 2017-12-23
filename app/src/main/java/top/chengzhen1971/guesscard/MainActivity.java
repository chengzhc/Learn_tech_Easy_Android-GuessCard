package top.chengzhen1971.guesscard;

import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //第二步，声明界面上的View（组件）
    ImageView iv_card_left,iv_card_center,iv_card_right,iv_result_img;
    Button btn_restart;
    TextView tv_result_text;
    ConstraintLayout lay_result,lay_cover;

    int cardLeftNumber,cardCenterNumber,cardRightNumber;

    boolean isShowCard = false;//是true，否false，

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //第一步，创建初始化方法
        initData();
        initView();

        //设置三张牌
        setCards();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //延时后要做的事情
                lay_cover.setVisibility(View.GONE);
            }
        },2000);
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

        iv_result_img = findViewById(R.id.iv_result_img);
        tv_result_text = findViewById(R.id.tv_result_text);
        lay_result = findViewById(R.id.lay_result);
        lay_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lay_result.setVisibility(View.GONE);
            }
        });

        lay_cover = findViewById(R.id.lay_cover);
    }

    void clickCardLeft(){
        //toast("卡左");
        showResult(cardLeftNumber);
        showCards();
    }

    void clickCardCenter(){
        //toast("卡中");
        showResult(cardCenterNumber);
        showCards();
    }

    void clickCardRight(){
        //toast("卡右");
        showResult(cardRightNumber);
        showCards();
    }

    void clickBtnRestart(){
        //toast("按键");
        hideCards();
        setCards();
    }

//    void setCards_bk(){
//        Random r = new Random();
//        //int整形(整数类型)，float浮点（小数）
//        //赋值
//        int luckCardNum = r.nextInt(3);
//
//        if(luckCardNum == 0){
//            cardLeftNumber = 0;
//            cardCenterNumber = 1;
//            cardRightNumber = 2;
//        }
//
//        if(luckCardNum == 1){
//            cardLeftNumber = 1;
//            cardCenterNumber = 0;
//            cardRightNumber = 2;
//        }
//
//        if(luckCardNum == 2){
//            cardLeftNumber = 1;
//            cardCenterNumber = 2;
//            cardRightNumber = 0;
//        }
//    }

    void setCards(){
        Random r = new Random();
        //int整形(整数类型)，float浮点（小数）
        //赋值
        int luckCardNum = r.nextInt(3);

        //1、switch等同于多个if()else语句，或多个else if语句
        //2、仅限于等于（==）判断
        //3、仅限于整数类型的判断
        switch (luckCardNum){
            case 0:
                cardLeftNumber = 0;
                cardCenterNumber = 1;
                cardRightNumber = 2;
                break;
            case 1:
                cardLeftNumber = 1;
                cardCenterNumber = 0;
                cardRightNumber = 2;
                break;
            case 2:
                cardLeftNumber = 1;
                cardCenterNumber = 2;
                cardRightNumber = 0;
                break;
            default:
                //这里可以不做处理，不写代码
                break;
        }
    }

    void showCards(){
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

        isShowCard = true;
    }

    void showResult(int cardNumber){
        if(isShowCard == true){
            return;
        }

        if(cardNumber == 0){
            //toast("赢了");
            lay_result.setVisibility(View.VISIBLE);
            iv_result_img.setImageResource(R.drawable.congratilation);
            tv_result_text.setText("恭喜你猜中了！");
        }else{
            //toast("输了");
            lay_result.setVisibility(View.VISIBLE);
            iv_result_img.setImageResource(R.drawable.try_again);
            tv_result_text.setText("太伤心了，再试一次吧！");
        }
    }



    void hideCards(){
        iv_card_left.setImageResource(R.drawable.card_back);
        iv_card_center.setImageResource(R.drawable.card_back);
        iv_card_right.setImageResource(R.drawable.card_back);
        isShowCard = false;
    }

    void toast(String info){
        Toast.makeText(this,info,Toast.LENGTH_SHORT).show();
    }
}

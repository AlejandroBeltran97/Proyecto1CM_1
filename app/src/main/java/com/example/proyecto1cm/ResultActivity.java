package com.example.proyecto1cm;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    LinearLayout myLayoutRes;
    LinearLayout ResL;
    AnimationDrawable animationDrawable;
    TextView greeting_user;
    ImageView usr_img;
    TextView RFC;
    TextView ZodiacName;
    ImageView ZodiacImage;
    TextView ChineseName;
    ImageView ChineseImage;
    TextView Age;

    private static final String TAG = "ResultActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ResL = (LinearLayout) findViewById(R.id.activity_res);
        myLayoutRes = (LinearLayout) findViewById(R.id.layout_usr);
        greeting_user = (TextView) findViewById(R.id.txt_usr);
        usr_img = (ImageView) findViewById(R.id.img_usr);
        RFC = (TextView) findViewById(R.id.RFC);
        ZodiacName = (TextView) findViewById(R.id.zodiac_name);
        ZodiacImage = (ImageView) findViewById(R.id.zodiac);
        ChineseName = (TextView) findViewById(R.id.chinese_name);
        ChineseImage = (ImageView) findViewById(R.id.chinese);
        Age = (TextView) findViewById(R.id.age);

        String usrname = getIntent().getStringExtra("UserName");
        String lastname = getIntent().getStringExtra("LastName");
        String date = getIntent().getStringExtra("Date");
        Log.d(TAG, "Usuario: " + usrname + "| Apellido: " + lastname + "| Fecha: " + date);
        String[] dateArray = date.split("/", 5);
        Log.d(TAG, dateArray[0] + "/" + dateArray[1] + "/" + dateArray[2]);
        for(int i = 0; i < dateArray.length; i++){
            if(dateArray[i].length() < 2){
                dateArray[i] = "0" + dateArray[i];
            }
        }
        greeting_user.setText(getString(R.string.greeting_user) + usrname);
        Log.d(TAG, dateArray[0] + "/" + dateArray[1] + "/" + dateArray[2]);
        String usrname_up = usrname.toUpperCase();
        String lastname_up = lastname.toUpperCase();
        String[] last_names = lastname_up.split(" ", 5);
        //Log.d(TAG, usrname + " | " + last_names.length);
        String patt = last_names[0];
        patt = patt.substring(0, 2);
        Log.d(TAG, patt);
        String matt = last_names[1];
        matt = matt.substring(0, 1);
        Log.d(TAG, matt);
        usrname_up = usrname_up.substring(0, 1);
        String day_rfc = dateArray[0];
        Log.d(TAG, "Day of RFC: " + day_rfc);
        String month_rfc = dateArray[1];
        Log.d(TAG, "Month of RFC: " + month_rfc);
        String year_rfc = dateArray[2];
        Log.d(TAG, "Year of RFC: " + year_rfc.substring(2,4));
        String rfc_usr = patt + matt + usrname_up + year_rfc.substring(2, 4) + month_rfc + day_rfc;
        RFC.setText(rfc_usr);

        int day_comp = Integer.parseInt(dateArray[0]);
        int month_comp = Integer.parseInt(dateArray[1]);
        int year_comp = Integer.parseInt(dateArray[2]);

        Calendar current_date = Calendar.getInstance();
        current_date.set(year_comp, month_comp-1, day_comp);

        Calendar min1 = Calendar.getInstance();
        Calendar max1 = Calendar.getInstance();
        min1.set(year_comp, 7-1, 26);
        max1.set(year_comp, 8-1, 22);

        Calendar min2 = Calendar.getInstance();
        Calendar max2 = Calendar.getInstance();
        min2.set(year_comp, 8-1, 23);
        max2.set(year_comp, 9-1, 19);

        Calendar min3 = Calendar.getInstance();
        Calendar max3 = Calendar.getInstance();
        min3.set(year_comp, 9-1, 20);
        max3.set(year_comp, 10-1, 17);

        Calendar min4 = Calendar.getInstance();
        Calendar max4 = Calendar.getInstance();
        min4.set(year_comp, 10-1, 18);
        max4.set(year_comp, 11-1, 14);

        Calendar min5 = Calendar.getInstance();
        Calendar max5 = Calendar.getInstance();
        min5.set(year_comp, 11-1, 15);
        max5.set(year_comp, 12-1, 12);

        Calendar min6 = Calendar.getInstance();
        Calendar max6 = Calendar.getInstance();
        min6.set(year_comp, 12-1, 13);
        max6.set(year_comp, 1-1, 9);

        Calendar min7 = Calendar.getInstance();
        Calendar max7 = Calendar.getInstance();
        min7.set(year_comp, 1-1, 10);
        max7.set(year_comp, 2-1, 6);

        Calendar min8 = Calendar.getInstance();
        Calendar max8 = Calendar.getInstance();
        min8.set(year_comp, 2-1, 7);
        max8.set(year_comp, 3-1, 6);

        Calendar min9 = Calendar.getInstance();
        Calendar max9 = Calendar.getInstance();
        min9.set(year_comp, 3-1, 7);
        max9.set(year_comp, 4-1, 3);

        Calendar min10 = Calendar.getInstance();
        Calendar max10 = Calendar.getInstance();
        min10.set(year_comp, 4-1, 4);
        max10.set(year_comp, 5-1, 1);

        Calendar min11 = Calendar.getInstance();
        Calendar max11 = Calendar.getInstance();
        min11.set(year_comp, 5-1, 2);
        max11.set(year_comp, 5-1, 29);

        Calendar min12 = Calendar.getInstance();
        Calendar max12 = Calendar.getInstance();
        min12.set(year_comp, 5-1, 30);
        max12.set(year_comp, 6-1, 26);

        Calendar min13 = Calendar.getInstance();
        Calendar max13 = Calendar.getInstance();
        min13.set(year_comp, 6-1, 27);
        max13.set(year_comp, 7-1, 25);

        if(current_date.after(min1) && current_date.before(max1)){
            usr_img.setImageResource(R.drawable.p26072208);
        }
        else{
            if(current_date.after(min2) && current_date.before(max2)){
                usr_img.setImageResource(R.drawable.p23081909);
            }
            else{
                if(current_date.after(min3) && current_date.before(max3)){
                    usr_img.setImageResource(R.drawable.p20091710);
                }
                else{
                    if(current_date.after(min4) && current_date.before(max4)){
                        usr_img.setImageResource(R.drawable.p18101411);
                    }
                    else{
                        if(current_date.after(min5) && current_date.before(max5)){
                            usr_img.setImageResource(R.drawable.p15111212);
                        }
                        else{
                            if(current_date.after(min6) || current_date.before(max6)){
                                usr_img.setImageResource(R.drawable.p13120901);
                            }
                            else{
                                if(current_date.after(min7) && current_date.before(max7)){
                                    usr_img.setImageResource(R.drawable.p10010602);
                                }
                                else{
                                    if(current_date.after(min8) && current_date.before(max8)){
                                        usr_img.setImageResource(R.drawable.p07020603);
                                    }
                                    else{
                                        if(current_date.after(min9) && current_date.before(max9)){
                                            usr_img.setImageResource(R.drawable.p07030304);
                                        }
                                        else{
                                            if(current_date.after(min10) && current_date.before(max10)){
                                                usr_img.setImageResource(R.drawable.p04040105);
                                            }
                                            else{
                                                if(current_date.after(min11) && current_date.before(max11)){
                                                    usr_img.setImageResource(R.drawable.p02052905);
                                                }
                                                else{
                                                    if(current_date.after(min12) && current_date.before(min12)){
                                                        usr_img.setImageResource(R.drawable.p30052606);
                                                    }
                                                    else{
                                                        usr_img.setImageResource(R.drawable.p27062507);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Calendar zod_min1 = Calendar.getInstance();
        Calendar zod_max1 = Calendar.getInstance();
        zod_min1.set(year_comp, 3-1, 21);
        zod_max1.set(year_comp, 4-1, 20);

        Calendar zod_min2 = Calendar.getInstance();
        Calendar zod_max2 = Calendar.getInstance();
        zod_min2.set(year_comp, 4-1, 21);
        zod_max2.set(year_comp, 5-1, 20);

        Calendar zod_min3 = Calendar.getInstance();
        Calendar zod_max3 = Calendar.getInstance();
        zod_min3.set(year_comp, 5-1, 21);
        zod_max3.set(year_comp, 6-1, 21);

        Calendar zod_min4 = Calendar.getInstance();
        Calendar zod_max4 = Calendar.getInstance();
        zod_min4.set(year_comp, 6-1, 22);
        zod_max4.set(year_comp, 7-1, 22);

        Calendar zod_min5 = Calendar.getInstance();
        Calendar zod_max5 = Calendar.getInstance();
        zod_min5.set(year_comp, 7-1, 23);
        zod_max5.set(year_comp, 8-1, 22);

        Calendar zod_min6 = Calendar.getInstance();
        Calendar zod_max6 = Calendar.getInstance();
        zod_min6.set(year_comp, 8-1, 23);
        zod_max6.set(year_comp, 9-1, 22);

        Calendar zod_min7 = Calendar.getInstance();
        Calendar zod_max7 = Calendar.getInstance();
        zod_min7.set(year_comp, 9-1, 23);
        zod_max7.set(year_comp, 10-1, 21);

        Calendar zod_min8 = Calendar.getInstance();
        Calendar zod_max8 = Calendar.getInstance();
        zod_min8.set(year_comp, 10-1, 22);
        zod_max8.set(year_comp, 11-1, 22);

        Calendar zod_min9 = Calendar.getInstance();
        Calendar zod_max9 = Calendar.getInstance();
        zod_min9.set(year_comp, 11-1, 23);
        zod_max9.set(year_comp, 12-1, 21);

        Calendar zod_min10 = Calendar.getInstance();
        Calendar zod_max10 = Calendar.getInstance();
        zod_min10.set(year_comp, 12-1, 22);
        zod_max10.set(year_comp, 1-1, 20);

        Calendar zod_min11 = Calendar.getInstance();
        Calendar zod_max11 = Calendar.getInstance();
        zod_min11.set(year_comp, 1-1, 21);
        zod_max11.set(year_comp, 2-1, 18);

        Calendar zod_min12 = Calendar.getInstance();
        Calendar zod_max12 = Calendar.getInstance();
        zod_min12.set(year_comp, 2-1, 19);
        zod_max12.set(year_comp, 3-1, 20);

        if(current_date.after(zod_min1) && current_date.before(zod_max1)){
            ZodiacName.setText(getString(R.string.zodiac_aries));
            ZodiacImage.setImageResource(R.drawable.aries);
        }
        else{
            if(current_date.after(zod_min2) && current_date.before(zod_max2)){
                ZodiacName.setText(getString(R.string.zodiac_taurus));
                ZodiacImage.setImageResource(R.drawable.taurus);
            }
            else{
                if(current_date.after(zod_min3) && current_date.before(zod_max3)){
                    ZodiacName.setText(getString(R.string.zodiac_gemini));
                    ZodiacImage.setImageResource(R.drawable.gemini);
                }
                else{
                    if(current_date.after(zod_min4) && current_date.before(zod_max4)){
                        ZodiacName.setText(getString(R.string.zodiac_cancer));
                        ZodiacImage.setImageResource(R.drawable.cancer);
                    }
                    else{
                        if(current_date.after(zod_min5) && current_date.before(zod_max5)){
                            ZodiacName.setText(getString(R.string.zodiac_leo));
                            ZodiacImage.setImageResource(R.drawable.leo);
                        }
                        else{
                            if(current_date.after(zod_min6) && current_date.before(zod_max6)){
                                ZodiacName.setText(getString(R.string.zodiac_virgo));
                                ZodiacImage.setImageResource(R.drawable.virgo);
                            }
                            else{
                                if(current_date.after(zod_min7) && current_date.before(zod_max7)){
                                    ZodiacName.setText(getString(R.string.zodiac_libra));
                                    ZodiacImage.setImageResource(R.drawable.libra);
                                }
                                else{
                                    if(current_date.after(zod_min8) && current_date.before(zod_max8)){
                                        ZodiacName.setText(getString(R.string.zodiac_escorpio));
                                        ZodiacImage.setImageResource(R.drawable.scorpio);
                                    }
                                    else{
                                        if(current_date.after(zod_min9) && current_date.before(zod_max9)){
                                            ZodiacName.setText(getString(R.string.zodiac_sagitario));
                                            ZodiacImage.setImageResource(R.drawable.sagittarius);
                                        }
                                        else{
                                            if(current_date.after(zod_min10) || current_date.before(zod_max10)){
                                                ZodiacName.setText(getString(R.string.zodiac_capr));
                                                ZodiacImage.setImageResource(R.drawable.capricorn);
                                            }
                                            else{
                                                if(current_date.after(zod_min11) && current_date.before(zod_max11)){
                                                    ZodiacName.setText(getString(R.string.zodiac_acu));
                                                    ZodiacImage.setImageResource(R.drawable.aquarius);
                                                }
                                                else{
                                                    ZodiacName.setText(getString(R.string.zodiac_pis));
                                                    ZodiacImage.setImageResource(R.drawable.pisces);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        List<Integer> arr_rat = new ArrayList<Integer>();
        arr_rat.add(1924);
        List<Integer> arr_ox = new ArrayList<Integer>();
        arr_ox.add(1925);
        List<Integer> arr_tiger = new ArrayList<Integer>();
        arr_tiger.add(1926);
        List<Integer> arr_rabbit = new ArrayList<Integer>();
        arr_rabbit.add(1927);
        List<Integer> arr_dragon = new ArrayList<Integer>();
        arr_dragon.add(1928);
        List<Integer> arr_snake = new ArrayList<Integer>();
        arr_snake.add(1929);
        List<Integer> arr_horse = new ArrayList<Integer>();
        arr_horse.add(1930);
        List<Integer> arr_goat = new ArrayList<Integer>();
        arr_goat.add(1931);
        List<Integer> arr_monkey = new ArrayList<Integer>();
        arr_monkey.add(1932);
        List<Integer> arr_rooster = new ArrayList<Integer>();
        arr_rooster.add(1933);
        List<Integer> arr_dog = new ArrayList<Integer>();
        arr_dog.add(1934);
        List<Integer> arr_pig = new ArrayList<Integer>();
        arr_pig.add(1935);
        for(int j = 1; j <= 8; j++){
            arr_rat.add(arr_rat.get(j - 1) + 12);
            arr_ox.add(arr_ox.get(j - 1) + 12);
            arr_tiger.add(arr_tiger.get(j - 1) + 12);
            arr_rabbit.add(arr_rabbit.get(j - 1) + 12);
            arr_dragon.add(arr_dragon.get(j - 1) + 12);
            arr_snake.add(arr_snake.get(j - 1) + 12);
            arr_horse.add(arr_horse.get(j - 1) + 12);
            arr_goat.add(arr_goat.get(j - 1) + 12);
            arr_monkey.add(arr_monkey.get(j - 1) + 12);
            arr_rooster.add(arr_rooster.get(j - 1) + 12);
            arr_dog.add(arr_dog.get(j - 1) + 12);
            arr_pig.add(arr_pig.get(j - 1) + 12);
        }

        if(arr_rat.contains(year_comp)){
            ChineseName.setText(getString(R.string.chinese_rat));
            ChineseImage.setImageResource(R.drawable.rat);
        }
        else{
            if(arr_ox.contains(year_comp)){
                ChineseName.setText(getString(R.string.chinese_Ox));
                ChineseImage.setImageResource(R.drawable.ox);
            }
            else{
                if(arr_tiger.contains(year_comp)){
                    ChineseName.setText(getString(R.string.chinese_tiger));
                    ChineseImage.setImageResource(R.drawable.tiger);
                }
                else{
                    if(arr_rabbit.contains(year_comp)){
                        ChineseName.setText(getString(R.string.chinese_rabbit));
                        ChineseImage.setImageResource(R.drawable.rabbit);
                    }
                    else{
                        if(arr_dragon.contains(year_comp)){
                            ChineseName.setText(getString(R.string.chinese_dragon));
                            ChineseImage.setImageResource(R.drawable.dragon);
                        }
                        else{
                            if(arr_snake.contains(year_comp)){
                                ChineseName.setText(getString(R.string.chinese_dragon));
                                ChineseImage.setImageResource(R.drawable.dragon);
                            }
                            else{
                                if(arr_horse.contains(year_comp)){
                                    ChineseName.setText(getString(R.string.chinese_horse));
                                    ChineseImage.setImageResource(R.drawable.horse);
                                }
                                else{
                                    if(arr_goat.contains(year_comp)){
                                        ChineseName.setText(getString(R.string.chinese_goat));
                                        ChineseImage.setImageResource(R.drawable.goat);
                                    }
                                    else{
                                        if(arr_monkey.contains(year_comp)){
                                            ChineseName.setText(getString(R.string.chinese_monkey));
                                            ChineseImage.setImageResource(R.drawable.monkey);
                                        }
                                        else{
                                            if(arr_rooster.contains(year_comp)){
                                                ChineseName.setText(getString(R.string.chinese_rooster));
                                                ChineseImage.setImageResource(R.drawable.rooster);
                                            }
                                            else{
                                                if(arr_dog.contains(year_comp)){
                                                    ChineseName.setText(getString(R.string.chinese_dog));
                                                    ChineseImage.setImageResource(R.drawable.dog);
                                                }
                                                else{
                                                    ChineseName.setText(getString(R.string.chinese_pig));
                                                    ChineseImage.setImageResource(R.drawable.pig);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Calendar today = Calendar.getInstance();
        int usr_age = today.get(Calendar.YEAR) - current_date.get(Calendar.YEAR);
        if(today.get(Calendar.DAY_OF_YEAR) < current_date.get(Calendar.DAY_OF_YEAR)){
            usr_age--;
        }
        Age.setText(Integer.toString(usr_age));

        animationDrawable = (AnimationDrawable) myLayoutRes.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
    }
}

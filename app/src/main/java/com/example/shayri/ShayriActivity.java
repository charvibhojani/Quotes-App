package com.example.shayri;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShayriActivity extends Activity implements ShayriAdapter.Myclick {

    RecyclerView lv;
    TextView name;
    ImageView back;
    ArrayList<Shayriitem> shayriitems = new ArrayList<>();
    String cat = "";
    String title;
    ProgressBar pb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayri);

        lv = findViewById(R.id.lv);
        name = findViewById(R.id.name);
        back = findViewById(R.id.back);
        pb = findViewById(R.id.pb);

//        cat = getIntent().getExtras().getString("title");

        cat = MyApp.getShayri();

        name.setText(cat);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShayriActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        if (cat.equalsIgnoreCase("Anniversary")) {
            shayriitems.add(new Shayriitem("May the love you share become\n" +
                    "stronger as both of you grow old together.\n" +
                    "I wish you a lifetime of happiness together.\n" +
                    "Happy wedding anniversary!"));
            shayriitems.add(new Shayriitem("Looking at you two my heart believes,\n" +
                    "That marriage is where love is conceived!\n" +
                    "Happy wedding anniversary !"));
            shayriitems.add(new Shayriitem("Congratulations on your Anniversary !\n" +
                    "Many best wishes and blessings\n" +
                    "as you continue walking life’s paths\n" +
                    "hand-in-hand and heart-in-heart.\n" +
                    "Happy Anniversary !"));
            shayriitems.add(new Shayriitem("May God fill your life with more beautiful moments\n" +
                    "and colorful memories in the coming years.\n" +
                    "Happy Wedding Anniversary !"));
            shayriitems.add(new Shayriitem("Cheers to another year of\n" +
                    "creating beautiful memories together.\n" +
                    "May God bless you two together forever.\n" +
                    "Happy Anniversary!"));
            shayriitems.add(new Shayriitem("Congratulations to one of the most\n" +
                    "romantic couples that we have ever witness.\n" +
                    "May Lord bless you and\n" +
                    "always keep you together.\n" +
                    "Happy anniversary !"));
            shayriitems.add(new Shayriitem("On this very special day of yours,\n" +
                    "sending you all my warm love.\n" +
                    "I hope you get blessed with the\n" +
                    "very ounce of happiness in the world.\n" +
                    "Happy Wedding anniversary."));
            shayriitems.add(new Shayriitem("Celebrate and enjoy this beautiful day\n" +
                    "which is only reserved for you.\n" +
                    "Sending you both love and\n" +
                    "sweet wishes on your anniversary."));
        }

        if (cat.equalsIgnoreCase("Birthday")) {
            shayriitems.add(new Shayriitem("You can do it for another year.\n" +
                    "Stay healthy, stay well.\n" +
                    "I wish this again and again.\n" +
                    "~ Happy Birthday ❦"));
            shayriitems.add(new Shayriitem("Today is your birthday\n" +
                    "Happy happy day to you.\n" +
                    "Always have your mind,\n" +
                    "Colorful with such joy.\n" +
                    "~ Happy Birthday ❦"));
            shayriitems.add(new Shayriitem("Happy birthday,\n" +
                    "Love and affection,\n" +
                    "Will reach you,\n" +
                    "I just hope this."));
            shayriitems.add(new Shayriitem("Year after year comes back\n" +
                    "Happy birthday\n" +
                    "Laughter is a colorful touch of happiness\n" +
                    "Gift day."));
            shayriitems.add(new Shayriitem("Joy rejoices\n" +
                    "Like your every day,\n" +
                    "Greetings to you today\n" +
                    "~ Happy Birthday "));
            shayriitems.add(new Shayriitem("A little while at this bar,\n" +
                    "Sleep deprivation,\n" +
                    "Look at the match,\n" +
                    "One more year is over.\n" +
                    "~ Happy Birthday"));
        }

        if (cat.equalsIgnoreCase("Love")) {
            shayriitems.add(new Shayriitem("Love is so strange Sometimes it’s a reason to live life & Sometimes it’s a reason to leave life.\n."));
            shayriitems.add(new Shayriitem("No one can Love Intelligently.\n" +
                    "Bcoz the Nature of True Love is Madness."));
            shayriitems.add(new Shayriitem("Love all, trust a few, do wrong to none."));
            shayriitems.add(new Shayriitem("All you need is love."));
            shayriitems.add(new Shayriitem("Loved you yesterday, love you still, always have, always will."));
            shayriitems.add(new Shayriitem("I need you like a heart needs a beat."));
        }

        if (cat.equalsIgnoreCase("Sad")) {
            shayriitems.add(new Shayriitem("Some nights i burn in the\n" +
                    "\n" +
                    "fire of my own thoughts."));
            shayriitems.add(new Shayriitem("I feel so far away from the one\n" +
                    "\n" +
                        "I wish to hold in my arms."));
            shayriitems.add(new Shayriitem("Sometimes all you ever want is someone\n" +
                    "\n" +
                    "to want and need you as much as\n" +
                    "\n" +
                    "you want and need them.."));
            shayriitems.add(new Shayriitem("I will never stop caring,\n" +
                    "\n" +
                    "but if you decide to push me away,\n" +
                    "\n" +
                    "i will go."));
            shayriitems.add(new Shayriitem("If it’s not a happy ending\n" +
                    "\n" +
                    "then it’s not the ending at all.."));
            shayriitems.add(new Shayriitem("People cry not because they are weak,\n" +
                    "\n" +
                    "it’s because they’ve been strong for too long."));
        }

        if (cat.equalsIgnoreCase("Friends")) {
            shayriitems.add(new Shayriitem("Don’t make friends who are comfortable to be with. Make friends who will force you to lever yourself up."));
            shayriitems.add(new Shayriitem("The most beautiful discovery true friends make is that they can grow separately without growing apart."));
            shayriitems.add(new Shayriitem("Each friend represents a world in us, a world possibly not born until they arrive, and it is only by this meeting that a new world is born."));
            shayriitems.add(new Shayriitem("Life is partly what we make it, and partly what it is made by the friends we choose."));
            shayriitems.add(new Shayriitem("They may forget what you said, but they will never forget how you made them feel."));
            shayriitems.add(new Shayriitem("The best and most beautiful things in the world cannot be seen or even touched — they must be felt with the heart."));
        }

        if (cat.equalsIgnoreCase("Alone")) {
            shayriitems.add(new Shayriitem("It’s far better to be unhappy alone than unhappy with someone — so far."));
            shayriitems.add(new Shayriitem("Laugh and the world laughs with you, snore and you sleep alone."));
            shayriitems.add(new Shayriitem("It’s easy to stand with the crowd it takes courage to stand alone."));
            shayriitems.add(new Shayriitem("Sometimes, you need to be alone. Not to be lonely, but to enjoy your free time being yourself."));
            shayriitems.add(new Shayriitem("As I get older I’m more and more comfortable being alone."));
            shayriitems.add(new Shayriitem("Once you start loving your own presence, you stop chasing people in your life."));
        }

        if (cat.equalsIgnoreCase("Success")) {
            shayriitems.add(new Shayriitem("Success is not final; failure is not fatal: It is the courage to continue that counts."));
            shayriitems.add(new Shayriitem("It is better to fail in originality than to succeed in imitation."));
            shayriitems.add(new Shayriitem("The road to success and the road to failure are almost exactly the same."));
            shayriitems.add(new Shayriitem("Success usually comes to those who are too busy to be looking for it."));
            shayriitems.add(new Shayriitem("Opportunities don't happen. You create them."));
            shayriitems.add(new Shayriitem("Don't be afraid to give up the good to go for the great."));
        }

        if (cat.equalsIgnoreCase("Motivational")) {
            shayriitems.add(new Shayriitem("\"When you have a dream, you've got to grab it and never let go.\"."));
            shayriitems.add(new Shayriitem("Nothing is impossible. The word itself says 'I'm possible!."));
            shayriitems.add(new Shayriitem("There is nothing impossible to they who will try."));
            shayriitems.add(new Shayriitem("The bad news is time flies. The good news is you're the pilot."));
            shayriitems.add(new Shayriitem("Life has got all those twists and turns. You've got to hold on tight and off you go.."));
            shayriitems.add(new Shayriitem("Keep your face always toward the sunshine, and shadows will fall behind you."));
        }

        if (cat.equalsIgnoreCase("Inspirational")) {
            shayriitems.add(new Shayriitem("You can get everything in life you want if you will just help enough other people get what they want."));
            shayriitems.add(new Shayriitem("Inspiration does exist, but it must find you working."));
            shayriitems.add(new Shayriitem("Do the best you can."));
            shayriitems.add(new Shayriitem("Do what you can, with what you have, where you are."));
            shayriitems.add(new Shayriitem("It's never too late to be what you might've been."));
            shayriitems.add(new Shayriitem("If you can dream it, you can do it."));
        }

        if (cat.equalsIgnoreCase("Happy")) {
            shayriitems.add(new Shayriitem("A person needs just three things to be truly happy in this world: someone to love, something to do, and something to hope"));
            shayriitems.add(new Shayriitem("Smile every minute of the day. You never know who is falling in love with whom."));
            shayriitems.add(new Shayriitem("For every minute of anger, you lose sixty seconds of happiness. So, smile big and enjoy every minute of life"));
            shayriitems.add(new Shayriitem("Be crazy, Be stupid, Be silly, Be weird, Be whatever, Because life is too short to be anything but happy."));
            shayriitems.add(new Shayriitem("The only thing that will make you happy is being comfortable with who you are, and not who people think you are."));
            shayriitems.add(new Shayriitem("Positive thinking evokes more energy, more initiative and more happiness."));
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lv.setLayoutManager(linearLayoutManager);

        shayriAdapter = new ShayriAdapter(shayriitems, ShayriActivity.this, ShayriActivity.this);
        lv.setAdapter(shayriAdapter);

        lv.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                pb.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pb.setVisibility(View.GONE);
                        loadmore();
                    }
                }, 2000);
            }
        });
    }

    ShayriAdapter shayriAdapter;

    @Override
    public void getmypos(int pos) {
        cat = shayriitems.get(pos).getName();

        MyApp.setMylist(shayriitems);

        Intent intent = new Intent(ShayriActivity.this, Clickshayri.class);
//        intent.putExtra("title", cat);

        MyApp.setShayri(cat);

        MyApp.setpos(pos);

        MyApp.setvpos(pos);

        startActivity(intent);
    }

    public void loadmore() {
        if (cat.equalsIgnoreCase("Anniversary")) {
            shayriitems.add(new Shayriitem("May the love you share become\n" +
                    "stronger as both of you grow old together.\n" +
                    "I wish you a lifetime of happiness together.\n" +
                    "Happy wedding anniversary!"));
            shayriitems.add(new Shayriitem("Looking at you two my heart believes,\n" +
                    "That marriage is where love is conceived!\n" +
                    "Happy wedding anniversary !"));
            shayriitems.add(new Shayriitem("Congratulations on your Anniversary !\n" +
                    "Many best wishes and blessings\n" +
                    "as you continue walking life’s paths\n" +
                    "hand-in-hand and heart-in-heart.\n" +
                    "Happy Anniversary !"));
            shayriitems.add(new Shayriitem("May God fill your life with more beautiful moments\n" +
                    "and colorful memories in the coming years.\n" +
                    "Happy Wedding Anniversary !"));
            shayriitems.add(new Shayriitem("Cheers to another year of\n" +
                    "creating beautiful memories together.\n" +
                    "May God bless you two together forever.\n" +
                    "Happy Anniversary!"));
            shayriitems.add(new Shayriitem("Congratulations to one of the most\n" +
                    "romantic couples that we have ever witness.\n" +
                    "May Lord bless you and\n" +
                    "always keep you together.\n" +
                    "Happy anniversary !"));
            shayriitems.add(new Shayriitem("On this very special day of yours,\n" +
                    "sending you all my warm love.\n" +
                    "I hope you get blessed with the\n" +
                    "very ounce of happiness in the world.\n" +
                    "Happy Wedding anniversary."));
            shayriitems.add(new Shayriitem("Celebrate and enjoy this beautiful day\n" +
                    "which is only reserved for you.\n" +
                    "Sending you both love and\n" +
                    "sweet wishes on your anniversary."));
        }

        if (cat.equalsIgnoreCase("Birthday")) {
            shayriitems.add(new Shayriitem("You can do it for another year.\n" +
                    "Stay healthy, stay well.\n" +
                    "I wish this again and again.\n" +
                    "~ Happy Birthday ❦"));
            shayriitems.add(new Shayriitem("Today is your birthday\n" +
                    "Happy happy day to you.\n" +
                    "Always have your mind,\n" +
                    "Colorful with such joy.\n" +
                    "~ Happy Birthday ❦"));
            shayriitems.add(new Shayriitem("Happy birthday,\n" +
                    "Love and affection,\n" +
                    "Will reach you,\n" +
                    "I just hope this."));
            shayriitems.add(new Shayriitem("Year after year comes back\n" +
                    "Happy birthday\n" +
                    "Laughter is a colorful touch of happiness\n" +
                    "Gift day."));
            shayriitems.add(new Shayriitem("Joy rejoices\n" +
                    "Like your every day,\n" +
                    "Greetings to you today\n" +
                    "~ Happy Birthday "));
            shayriitems.add(new Shayriitem("A little while at this bar,\n" +
                    "Sleep deprivation,\n" +
                    "Look at the match,\n" +
                    "One more year is over.\n" +
                    "~ Happy Birthday"));
        }

        if (cat.equalsIgnoreCase("Love")) {
            shayriitems.add(new Shayriitem("Love is so strange Sometimes it’s a reason to live life & Sometimes it’s a reason to leave life.\n."));
            shayriitems.add(new Shayriitem("No one can Love Intelligently.\n" +
                    "Bcoz the Nature of True Love is Madness."));
            shayriitems.add(new Shayriitem("Love all, trust a few, do wrong to none."));
            shayriitems.add(new Shayriitem("All you need is love."));
            shayriitems.add(new Shayriitem("Loved you yesterday, love you still, always have, always will."));
            shayriitems.add(new Shayriitem("I need you like a heart needs a beat."));
        }

        if (cat.equalsIgnoreCase("Sad")) {
            shayriitems.add(new Shayriitem("Some nights i burn in the\n" +
                    "\n" +
                    "fire of my own thoughts."));
            shayriitems.add(new Shayriitem("I feel so far away from the one\n" +
                    "\n" +
                    "I wish to hold in my arms."));
            shayriitems.add(new Shayriitem("Sometimes all you ever want is someone\n" +
                    "\n" +
                    "to want and need you as much as\n" +
                    "\n" +
                    "you want and need them.."));
            shayriitems.add(new Shayriitem("I will never stop caring,\n" +
                    "\n" +
                    "but if you decide to push me away,\n" +
                    "\n" +
                    "i will go."));
            shayriitems.add(new Shayriitem("If it’s not a happy ending\n" +
                    "\n" +
                    "then it’s not the ending at all.."));
            shayriitems.add(new Shayriitem("People cry not because they are weak,\n" +
                    "\n" +
                    "it’s because they’ve been strong for too long."));
        }

        if (cat.equalsIgnoreCase("Friends")) {
            shayriitems.add(new Shayriitem("Don’t make friends who are comfortable to be with. Make friends who will force you to lever yourself up."));
            shayriitems.add(new Shayriitem("The most beautiful discovery true friends make is that they can grow separately without growing apart."));
            shayriitems.add(new Shayriitem("Each friend represents a world in us, a world possibly not born until they arrive, and it is only by this meeting that a new world is born."));
            shayriitems.add(new Shayriitem("Life is partly what we make it, and partly what it is made by the friends we choose."));
            shayriitems.add(new Shayriitem("They may forget what you said, but they will never forget how you made them feel."));
            shayriitems.add(new Shayriitem("The best and most beautiful things in the world cannot be seen or even touched — they must be felt with the heart."));
        }

        if (cat.equalsIgnoreCase("Alone")) {
            shayriitems.add(new Shayriitem("It’s far better to be unhappy alone than unhappy with someone — so far."));
            shayriitems.add(new Shayriitem("Laugh and the world laughs with you, snore and you sleep alone."));
            shayriitems.add(new Shayriitem("It’s easy to stand with the crowd it takes courage to stand alone."));
            shayriitems.add(new Shayriitem("Sometimes, you need to be alone. Not to be lonely, but to enjoy your free time being yourself."));
            shayriitems.add(new Shayriitem("As I get older I’m more and more comfortable being alone."));
            shayriitems.add(new Shayriitem("Once you start loving your own presence, you stop chasing people in your life."));
        }

        if (cat.equalsIgnoreCase("Success")) {
            shayriitems.add(new Shayriitem("Success is not final; failure is not fatal: It is the courage to continue that counts."));
            shayriitems.add(new Shayriitem("It is better to fail in originality than to succeed in imitation."));
            shayriitems.add(new Shayriitem("The road to success and the road to failure are almost exactly the same."));
            shayriitems.add(new Shayriitem("Success usually comes to those who are too busy to be looking for it."));
            shayriitems.add(new Shayriitem("Opportunities don't happen. You create them."));
            shayriitems.add(new Shayriitem("Don't be afraid to give up the good to go for the great."));
        }

        if (cat.equalsIgnoreCase("Motivational")) {
            shayriitems.add(new Shayriitem("\"When you have a dream, you've got to grab it and never let go.\"."));
            shayriitems.add(new Shayriitem("Nothing is impossible. The word itself says 'I'm possible!."));
            shayriitems.add(new Shayriitem("There is nothing impossible to they who will try."));
            shayriitems.add(new Shayriitem("The bad news is time flies. The good news is you're the pilot."));
            shayriitems.add(new Shayriitem("Life has got all those twists and turns. You've got to hold on tight and off you go.."));
            shayriitems.add(new Shayriitem("Keep your face always toward the sunshine, and shadows will fall behind you."));
        }

        if (cat.equalsIgnoreCase("Inspirational")) {
            shayriitems.add(new Shayriitem("You can get everything in life you want if you will just help enough other people get what they want."));
            shayriitems.add(new Shayriitem("Inspiration does exist, but it must find you working."));
            shayriitems.add(new Shayriitem("Do the best you can."));
            shayriitems.add(new Shayriitem("Do what you can, with what you have, where you are."));
            shayriitems.add(new Shayriitem("It's never too late to be what you might've been."));
            shayriitems.add(new Shayriitem("If you can dream it, you can do it."));
        }

        if (cat.equalsIgnoreCase("Happy")) {
            shayriitems.add(new Shayriitem("A person needs just three things to be truly happy in this world: someone to love, something to do, and something to hope"));
            shayriitems.add(new Shayriitem("Smile every minute of the day. You never know who is falling in love with whom."));
            shayriitems.add(new Shayriitem("For every minute of anger, you lose sixty seconds of happiness. So, smile big and enjoy every minute of life"));
            shayriitems.add(new Shayriitem("Be crazy, Be stupid, Be silly, Be weird, Be whatever, Because life is too short to be anything but happy."));
            shayriitems.add(new Shayriitem("The only thing that will make you happy is being comfortable with who you are, and not who people think you are."));
            shayriitems.add(new Shayriitem("Positive thinking evokes more energy, more initiative and more happiness."));
        }

        shayriAdapter.notifyDataSetChanged();
    }
}

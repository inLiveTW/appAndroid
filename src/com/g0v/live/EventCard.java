/*
 * ******************************************************************************
 *   Copyright (c) 2013-2014 Gabriele Mariotti.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  *****************************************************************************
 */

package com.g0v.live;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.g0v.live.stock.ListStockAdapter;
import com.g0v.live.stock.Stock;
import com.g0v.live.stock.StockListLayout;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;

/**
 * This class provides a simple card as Google Now Stock
 *
 * @author Gabriele Mariotti (gabri.mariotti@gmail.com)
 */
public class EventCard extends Card {
	
	View view;

	public EventCard(Context context) {
        super(context, R.layout.card_live_layout);
        init();
    }

    public EventCard(Context context, int innerLayout) {
        super(context, innerLayout);
        init();
    }

    private void init() {
//        CardHeader header = new CardHeader(getContext());
//        header.setButtonOverflowVisible(true);
//        header.setTitle("Google Maps");
//        header.setPopupMenu(R.menu.popupmain, new CardHeader.OnClickCardHeaderPopupMenuListener() {
//            @Override
//            public void onMenuItemClick(BaseCard card, MenuItem item) {
//                Toast.makeText(getContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
//            }
//        });

//        addCardHeader(header);

//        CardThumbnail thumbnail = new CardThumbnail(getContext());
//        thumbnail.setCustomSource(new CardThumbnail.CustomSource() {
//            @Override
//            public String getTag() {
//                return "com.google.android.apps.maps";
//            }
//
//            @Override
//            public Bitmap getBitmap() {
//                PackageManager pm = mContext.getPackageManager();
//                Bitmap bitmap = null;
//                try {
//                    bitmap = drawableToBitmap(pm.getApplicationIcon(getTag()));
//                } catch (PackageManager.NameNotFoundException e) {
//                }
//                return bitmap;
//            }
//
//            private Bitmap drawableToBitmap(Drawable drawable) {
//                if (drawable instanceof BitmapDrawable) {
//                    return ((BitmapDrawable) drawable).getBitmap();
//                }
//
//                Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
//                Canvas canvas = new Canvas(bitmap);
//                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
//                drawable.draw(canvas);
//
//                return bitmap;
//            }
//        });
//        addCardThumbnail(thumbnail);

        //Add onClick Listener
        setOnClickListener(new OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getContext(), "Click Listener card=" , Toast.LENGTH_LONG).show();
            }
        });

        //Add swipe Listener
        setOnSwipeListener(new OnSwipeListener() {
            @Override
            public void onSwipe(Card card) {
                Toast.makeText(getContext(), "Card removed", Toast.LENGTH_LONG).show();
            }
        });
    }
    
    public void setThumbnail(String imageUrl)
    {
    }

    
    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
    	
    	ImageView imageView = (ImageView) view.findViewById(R.id.card_thumbnail_image);
    	
    	new ImageLoadTask(
    			"http://lh5.googleusercontent.com/-N8bz9q4Kz0I/AAAAAAAAAAI/AAAAAAAAAAs/Icl2bQMyK7c/s265-c-k-no/photo.jpg",
    			imageView
    	).execute(null, null);

        TextView title = (TextView) view.findViewById(R.id.card_header_title);
        title.setText("巨獸搖滾！幹拒馬！拆政府！台灣獨立...");
        title.setMaxLines(1);

        TextView labal = (TextView) view.findViewById(R.id.card_header_labal);
        labal.setText("事件通知");

        TextView subtitle = (TextView) view.findViewById(R.id.card_header_subtitle);
        subtitle.setText("Very popular with...");
    }
}

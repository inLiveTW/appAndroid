package com.g0v.live;

import android.support.v4.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.ShareActionProvider;

import java.io.File;
import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.utils.BitmapUtils;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;

/**
 * Card Examples
 *
 * @author Gabriele Mariotti (gabri.mariotti@gmail.com)
 */
public class LiveFragment extends Fragment {

    protected ScrollView mScrollView;
    private CardView cardView;
    private ShareActionProvider mShareActionProvider;
    private File photofile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.demo_fragment_stock_card, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        mScrollView = (ScrollView) getActivity().findViewById(R.id.card_scrollview);

        initCard();

        if (photofile==null){
            if (mShareActionProvider != null) {
                getActivity().invalidateOptionsMenu();
            }
        }
    }


    /**
     * This method builds a simple card
     */
    private void initCard() {

        //Create a Card
//        GoogleNowStockCard card= new GoogleNowStockCard(getActivity());
//
//        //Set card in the cardView
//        cardView = (CardView) getActivity().findViewById(R.id.carddemo_GoogleNowStock);
//        cardView.setCard(card);

        ArrayList<Card> cards = new ArrayList<Card>();
        for (int i=0;i<10;i++) {

            //Create a Card
        	EventCard card = new EventCard(getActivity());

            //Create a CardHeader
//            CardHeader header = new CardHeader(getActivity());
//            header.setTitle("´ú¸ÕCard");
//            card.addCardHeader(header);

//            Create thumbnail
//            CardThumbnail thumb = new CardThumbnail(getActivity());
//            thumb.setUrlResource("http://lh5.googleusercontent.com/-N8bz9q4Kz0I/AAAAAAAAAAI/AAAAAAAAAAs/Icl2bQMyK7c/s265-c-k-no/photo.jpg");
//            thumb.setErrorResource(R.drawable.ic_error_loadingorangesmall);
//            card.addCardThumbnail(thumb);
        	
            cards.add(card);
        }

        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(getActivity(),cards);

        CardListView listView = (CardListView) getActivity().findViewById(R.id.carddemo_list_cwl);
        if (listView!=null){
            listView.setAdapter(mCardArrayAdapter);
        }
        
//    	Card card = new Card(getActivity());
//    	card.setTitle("This is Title");
//        
//    	LinearLayout cardls;
//    	cardls = (LinearLayout) getActivity().findViewById(R.id.carddemo_list);
//    	
//    	cardls.add
//    	
//        //Set the adapter
//        mCardArrayAdapter = new CardGridArrayAdapter(getActivity(), cards);
//
//        mListView = (CardGridView) getActivity().findViewById(R.id.carddemo_extras_grid_base1);
//        if (mListView != null) {
//            setAlphaAdapter();
//        }
    }

    private Intent getShareIntent(){
        if (cardView!=null){
            photofile = BitmapUtils.createFileFromBitmap(cardView.createBitmap());
            if (photofile!=null){
                return BitmapUtils.createIntentFromImage(photofile);
            }else{
                return getDefaultIntent();
            }
        }else{
            return getDefaultIntent();
        }
    }

    /** Defines a default (dummy) share intent to initialze the action provider.
     * However, as soon as the actual content to be used in the intent
     * is known or changes, you must update the share intent by again calling
     * mShareActionProvider.setShareIntent()
     */
    private Intent getDefaultIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        return intent;
    }


}
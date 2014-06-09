package com.Riktur.rikturs4.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;


public class RikturMoments extends Activity {

    ImageView image;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riktur_moments);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

       }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.riktur_moments, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return MomentFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class MomentFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        Intent intent;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static MomentFragment newInstance(int sectionNumber) {
            MomentFragment fragment = new MomentFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public MomentFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            //Load the image
            View rootView = inflater.inflate(R.layout.fragment_riktur_moments, container, false);
            //handy imagehelper jar used to map url to imageview
            UrlImageViewHelper imageHelper = new UrlImageViewHelper();
            ImageView image = (ImageView) rootView.findViewById(R.id.imageMoment);

            //Apply any url to the imageview
            imageHelper.setUrlDrawable(image, "http://lorempixel.com/400/200/", null, 0);

            //button to launch RikturWeb
            intent = new Intent(getActivity(), MomentMapActivity.class);
            final Button button = (Button) rootView.findViewById(R.id.RikturWebButton);

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(intent);
                }
            });

            TextView comments =(TextView) rootView.findViewById(R.id.Comment);

            comments.setText("Lorem ipsum dolor sit amet, te cum prodesset repudiandae, ex quem appareat mel. www.google.com te, nec ne dictas oporteat. Duo probo debet eu, id appareat conclusionemque nec, ex intellegat consectetuer concludaturque his. His no velit legere quaeque. Tollit doming pri ad, mea iusto nostro eu. Te eos odio exerci mucius.\n" +
                    "\n" +
                    "Case melius probatus ex mea. Sonet cetero detraxit sea ex, lorem feugait appareat in vis. In usu quis pertinax, in has iudico accumsan necessitatibus. Nihil mandamus ea quo. Duo ei virtute propriae perpetua, mea vidit dictas vulputate ex, has docendi facilisis inciderint no.\n" +
                    "\n" +
                    "Tale molestie dissentiet eam ei, corpora corrumpit in his. Per ne utinam offendit constituto. Ut conceptam appellantur has, an mutat harum veniam has. Cu usu adhuc idque partem, dico hendrerit interpretaris per te, enim omnis corrumpit ad qui. Ut ius vero definitiones, sed errem labitur tractatos eu.\n" +
                    "\n" +
                    "Ex minimum menandri cum, te ornatus vivendum complectitur eam. Scribentur suscipiantur an his. Vide delectus est eu, at usu idque iracundia expetendis, senserit qualisque efficiendi ne eam. Et porro nihil vis, eu movet incorrupte cotidieque vim. Vel ei putent sententiae, postea principes contentiones te nec.\n" +
                    "\n" +
                    "Pro sanctus vituperata cu, posse tation utamur vel ad. No mei ullum discere maiorum, illud aperiam denique qui ei, aperiam mnesarchum in sit. Tation numquam nominavi vix ut, ex ullum summo omnesque vis, graeco verear mei eu. Munere animal cu vel. Ne usu nostro laoreet instructior.");

            return rootView;
        }

    }
}

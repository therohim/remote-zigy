package id.net.gmedia.remotezigy.home;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import java.util.List;

import id.net.gmedia.remotezigy.R;

public class PromoAdapter extends PagerAdapter {
//    private ArrayList<Integer> IMAGES;
    private List<PromoModel> promoModels;
    private LayoutInflater inflater;
    private Context context;


    public PromoAdapter(Context context, List<PromoModel> promoModels) {
        this.context = context;
        this.promoModels=promoModels;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return promoModels.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.list_promo, view, false);
        PromoModel s = promoModels.get(position);
        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);

        Glide.with(context)
                .load(s.getUrl())
                .placeholder(R.drawable.placeholder)
                .centerCrop()
                .into(imageView);

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}
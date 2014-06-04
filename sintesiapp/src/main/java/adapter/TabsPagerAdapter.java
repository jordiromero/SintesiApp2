package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;

import com.iesebre.sintesiapp2.sintesiapp.AmanidaFragment;
import com.iesebre.sintesiapp2.sintesiapp.ArrososFragment;
import com.iesebre.sintesiapp2.sintesiapp.CarnFragment;
import com.iesebre.sintesiapp2.sintesiapp.EntrantsFragment;
import com.iesebre.sintesiapp2.sintesiapp.PastaFragment;
import com.iesebre.sintesiapp2.sintesiapp.PeixosFragment;
import com.iesebre.sintesiapp2.sintesiapp.PostresFragment;
import com.iesebre.sintesiapp2.sintesiapp.SopaFragment;
import com.iesebre.sintesiapp2.sintesiapp.TotMenuFragment;
import com.iesebre.sintesiapp2.sintesiapp.VinsFragment;

/**
 * Created by jordi on 03/06/14.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int index){
        switch (index){
            case 0:
                return new TotMenuFragment();
            case 1:
                return new EntrantsFragment();
            case 2:
                return new AmanidaFragment();
            case 3:
                return new SopaFragment();
            case 4:
                return new ArrososFragment();
            case 5:
                return new PastaFragment();
            case 6:
                return new CarnFragment();
            case 7:
                return new PeixosFragment();
            case 8:
                return new PostresFragment();
            case 9:
                return new VinsFragment();
        }
        return null;
    }
    @Override
    public int getCount(){
        return 10;
    }


}

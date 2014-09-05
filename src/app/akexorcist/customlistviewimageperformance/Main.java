package app.akexorcist.customlistviewimageperformance;

import android.os.Bundle;
import android.widget.ListView;
import android.app.Activity;
import android.content.res.TypedArray;

public class Main extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		int[] array_res = getImageArray(R.array.my_image_array, R.drawable.ic_launcher);
		String[] array_string = getStringArray(R.array.my_string_array);
		
		ListView listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(new CustomListViewAdapter(getApplicationContext()
        		, android.R.id.text1, array_string, array_res));
	}
	
	public int[] getImageArray(int resId, int defResId) {
		TypedArray my_image_array = getResources().obtainTypedArray(resId);
		int[] array_res = new int[my_image_array.length()];
		for(int i = 0 ; i < array_res.length ; i++) 
			array_res[i] = my_image_array.getResourceId(i, defResId);
		my_image_array.recycle();
		return array_res;
	}
	
	public String[] getStringArray(int resId) {
		TypedArray my_string_array = getResources().obtainTypedArray(resId);
		String[] array_string = new String[my_string_array.length()];
		for(int i = 0 ; i < array_string.length ; i++) 
			array_string[i] = my_string_array.getString(i);
		my_string_array.recycle();
		return array_string;
	}
}

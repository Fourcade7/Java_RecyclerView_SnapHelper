
![image](https://user-images.githubusercontent.com/60017090/137475827-545741a9-c4b6-45b8-8195-b980fb94d4ee.png)





 
    <?xml version="1.0" encoding="utf-8"?>
    <ripple xmlns:android="http://schemas.android.com/apk/res/android"
          android:color="@color/purple_700">
         <item >
          <shape android:shape="oval">
             <corners android:radius="20dp"></corners>
             <solid android:color="@color/teal_200"></solid>
             <stroke android:color="@color/white" android:width="10dp"></stroke>
          </shape>
         </item>
    </ripple>
    
    
    
    
    <View
        android:id="@+id/view"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="@color/purple_500"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"

        app:layout_constraintStart_toStartOf="parent"></View>

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="85dp"
        android:layout_height="85dp"
        android:layout_marginBottom="20dp"
        android:background="@drawable/bg"
        android:clickable="true"
        android:padding="25dp"
        android:src="@drawable/ic_baseline_add_24"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"></ImageView>

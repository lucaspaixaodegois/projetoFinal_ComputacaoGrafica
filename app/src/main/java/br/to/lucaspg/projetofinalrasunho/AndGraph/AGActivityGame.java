/********************************************
 Class: AGAtivivityGame
 Description: Android activity class
 Author: Silvano Maneck Malfatti
 Date: 05/11/2013
 ********************************************/

//Engine package
package br.to.lucaspg.projetofinalrasunho.AndGraph;

//Used packages
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class AGActivityGame extends Activity
{
	//Attributes
	protected AGGameManager vrManager = null;

	/********************************************
	 * Name: AGActivity
	 * Description: constructor
	 * Parameters: Activity, boolean
	 * Returns: none
	 ******************************************/
	public void init(Activity context, boolean accel)
	{
		vrManager = new AGGameManager(context, accel);
	}

	/********************************************
	 * Name: getGameManager()
	 * Description: returns the manager object game
	 * Parameters: None
	 * Returns: AGGameManager
	 ******************************************/
	public AGGameManager getGameManager()
	{
		return vrManager;
	}
	
	/********************************************
	* Name: onCreate()
	* Description: method called to create the application
	* Parameters: Bundle
	* Returns: none
	******************************************/
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState); 
	}
  
	/*******************************************
	* Name: onPause()
	* Description: method called to pause application
	* Parameters: none
	* Returns: none
	******************************************/
	protected void onPause()
	{
		super.onPause();
		AGSoundManager.vrMusic.pause();
		vrManager.onPause();
	}

	protected void onStop()
	{
		super.onStop();
		AGSoundManager.vrMusic.pause();
		vrManager.onPause();
	}

	/*******************************************
	* Name: onResume()
	* Description: method called after resume application
	* Parameters: none
	* Returns: none
	******************************************/
	protected void onResume()
	{
		super.onResume();
		vrManager.onResume();
		AGSoundManager.vrMusic.play();
	}

	/*******************************************
	 * Name: onResume()
	 * Description: method called after resume application
	 * Parameters: none
	 * Returns: none
	 ******************************************/
	protected void onRestart()
	{
		super.onRestart();
		vrManager.onResume();
		AGSoundManager.vrMusic.play();
	}

	/*******************************************
	 * Name: onResume()
	 * Description: method called after resume application
	 * Parameters: none
	 * Returns: none
	 ******************************************/
	protected void onStart()
	{
		super.onStart();
		vrManager.onResume();
		AGSoundManager.vrMusic.play();
	}

	/*******************************************
	* Name: onBackPressed()
	* Description: method called when Android back button is pressed
	* Parameters: none
	* Returns: none
	*****************************************/
	public void onBackPressed()
	{
		AGInputManager.vrTouchEvents.bBackButtonClicked = true;
	}
  
	/*******************************************
	* Name: onDestroy()
	* Description: method called when applicatin is destroyed
	* Parameters: none
	* Returns: none
	*****************************************/
	protected void onDestroy()
	{
		super.onDestroy();
		vrManager.release();
		vrManager = null;
		System.gc();
	}
}

package it.alcacoop.gnubackgammon.aicalls;

import com.badlogic.gdx.Gdx;

import it.alcacoop.gnubackgammon.GameScreen;
import it.alcacoop.gnubackgammon.logic.FSM;
import it.alcacoop.gnubackgammon.logic.GnubgAPI;

public class UpdateMSCubeInfoAICall implements Runnable {

  int nCube; 
  int fCubeOwner;
  
  public UpdateMSCubeInfoAICall(int _nCube, int _fCubeOwner) {
    nCube = _nCube;
    fCubeOwner = _fCubeOwner;
  }

  @Override
  public void run() {
    GnubgAPI.UpdateMSCubeInfo(nCube, fCubeOwner);
    Gdx.app.postRunnable(new Runnable() {
      @Override
      public void run() {
        GameScreen.fsm.processEvent(FSM.Events.UPDATE_MS_CUBEINFO, 1);        
      }
    });
  }
}
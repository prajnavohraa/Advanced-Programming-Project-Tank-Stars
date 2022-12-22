package com.mygdx.game.others;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.Screens.MainGameScreen;
import com.mygdx.game.TankStarGame;

public class MyContactListener implements ContactListener {
    TankStarGame game;
    public MyContactListener(TankStarGame game){
        this.game=game;
    }
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();
        Body bodyA=fixA.getBody();
        Body bodyB=fixB.getBody();
        if("bullet".equals(fixA.getUserData())){
            game.Remove.add(bodyA);
        }
        if("bullet".equals(fixB.getUserData())){
            game.Remove.add(bodyB);
        }
        if("tank2".equals(fixA.getUserData()) && "bullet".equals(fixB.getUserData())){
            game.getTank2().setHealth();
            //System.out.println("Tank2 Health: "+game.tank2.getHealth());
        }
        if("tank2".equals(fixB.getUserData()) && "bullet".equals(fixA.getUserData())){
            game.getTank2().setHealth();
            //System.out.println("Tank2 Health: "+game.tank2.getHealth());
        }

        if("tank1".equals(fixA.getUserData()) && "bullet".equals(fixB.getUserData())){
            game.getTank1().setHealth();
            //System.out.println("Tank1 Health: "+game.tank1.getHealth());
        }
        if("tank1".equals(fixB.getUserData()) && "bullet".equals(fixA.getUserData())){
            game.getTank1().setHealth();
            //System.out.println("Tank1 Health: "+game.tank1.getHealth());
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}

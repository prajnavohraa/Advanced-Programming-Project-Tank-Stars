package com.mygdx.game.others;

import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.TankStarGame;

public class CollisionListenerTank2 implements ContactListener {
    TankStarGame game;
    public CollisionListenerTank2(TankStarGame game){
        this.game=game;
    }
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

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

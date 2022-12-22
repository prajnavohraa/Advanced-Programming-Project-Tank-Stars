package com.mygdx.game.others;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.mygdx.game.TankStarGame;

public class Tank_player {
    TankStarGame game;
    private Body player;
    private int health;
    private int fuel;


    public Tank_player(TankStarGame game, Body player){
        this.player=player;
        this.game=game;
        this.health=10;
        this.fuel=1000;
    }

    public int getFuel() {
        return fuel;
    }

    public int getHealth() {
        return health;
    }

    public Body getPlayer() {
        return player;
    }

    public void setFuel() {
        this.fuel-=1;
    }

    public void setHealth() {
        this.health-=1;
    }

    public void setPlayer(Body player) {
        this.player = player;
    }

//    public void create_bullets(float angle) {
//        CircleShape circle = new CircleShape();
//        circle.setRadius(0.5f);
//        BodyDef bdef = new BodyDef();
//        bdef.type = BodyDef.BodyType.DynamicBody;
//        Body bullet_body = game.world.createBody(bdef);
//        BulletClass bullet= new BulletClass(bullet_body,circle,bdef);
//        bullet.circle.setPosition(new Vector2(game.current_player.getPlayer().getPosition().x - (50 / 2f) / 16f + 80 / 16f, game.current_player.getPlayer().getPosition().y - (50 / 2f) / 16f + 60 / 16f));
//        //fixture.setUserData("bullet");
//        bullet.circle.dispose();
//        bullet_body.setLinearVelocity(30 * MathUtils.cos(angle), 40 * MathUtils.sin(angle) - 9.8f * Gdx.graphics.getDeltaTime());
//    }
}

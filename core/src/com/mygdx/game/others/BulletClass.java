//package com.mygdx.game.others;
//
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.physics.box2d.Body;
//import com.badlogic.gdx.physics.box2d.BodyDef;
//import com.badlogic.gdx.physics.box2d.CircleShape;
//import com.badlogic.gdx.physics.box2d.Fixture;
//
//public class BulletClass {
//    Body bullet_body;
//    CircleShape circle;
//    BodyDef bdef;
//    Fixture fixture;
//
//    public BulletClass(Body bullet_body, CircleShape circle, BodyDef bdef){
//        this.bullet_body=bullet_body;
//        this.circle=circle;
//        this.bdef=bdef;
//        this.fixture=this.bullet_body.createFixture(this.circle, 1);
//        this.fixture.setUserData("bullet");
//    }
//
//}

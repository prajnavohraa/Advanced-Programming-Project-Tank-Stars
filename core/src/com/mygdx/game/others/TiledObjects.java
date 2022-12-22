package com.mygdx.game.others;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.math.ConvexHull;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.sun.tools.javac.jvm.Code;

public class TiledObjects {
    public static void parseTiledObjectLayer(World world, MapObjects objects){

        for(MapObject object: objects){
            try{
                Shape shape;
                if(object instanceof PolylineMapObject){
                    shape=create_shape((PolylineMapObject)object);
                }
                else{
                    continue;
                }
                Body tile_body;
                BodyDef body_def=new BodyDef();
                body_def.type=BodyDef.BodyType.StaticBody;

                tile_body= world.createBody(body_def);
                tile_body.createFixture(shape,1.0f).setUserData("ground");
                shape.dispose();
            }
            catch (Exception e){

            }
        }
    }

    public static ChainShape create_shape(PolylineMapObject object){
        //PolygonShape polygon = new PolygonShape();
        float[] vertices= object.getPolyline().getTransformedVertices();
        Vector2[] ground_vertices= new Vector2[vertices.length/2];
        for(int i=0; i<ground_vertices.length; i++){
            ground_vertices[i]=new Vector2(vertices[i*2]/16f, vertices[2*i+1]/16f);
        }
        ChainShape cs = new ChainShape();
        cs.createChain(ground_vertices);
        return cs;
    }
}



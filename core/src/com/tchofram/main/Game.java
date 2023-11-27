package com.tchofram.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Vector;

public class Game extends ApplicationAdapter{
	private OrthographicCamera cam;
	private ShapeRenderer sr;
	private Vector3 pos;
	public void create(){
		sr=new ShapeRenderer();
		cam=new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		pos=new Vector3(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight()/2,0);
	}
	public void render(){
		cam.update();
		if(Gdx.input.isTouched()){
			pos.set(Gdx.input.getX(),Gdx.input.getY(),0);
			cam.unproject(pos);
		}
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.ORANGE);
		sr.circle(pos.x, pos.y, 80 );
		sr.end();

	}
public void dispose(){
sr.dispose();
}
}

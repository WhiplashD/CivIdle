package com.cividle.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 *
 * @author Whiplash
 */
public class UI {

    Skin skin;
    Stage stage;
    SpriteBatch batch;
    Game game;
    final TextButton button;
    final TextButton button1;
    final Label foodLabel;
    
    public UI(final Game game) {
        batch = new SpriteBatch();
        stage = new Stage();
        this.game = game;
        Gdx.input.setInputProcessor(stage);

// A skin can be loaded via JSON or defined programmatically, either is fine. Using a skin is optional but strongly
// recommended solely for the convenience of getting a texture, region, etc as a drawable, tinted drawable, etc.
        skin = new Skin();

// Generate a 1x1 white texture and store it in the skin named "white".
        Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);

        pixmap.setColor(Color.WHITE);

        pixmap.fill();

        skin.add("white", new Texture(pixmap));

// Store the default libgdx font under the name "default".
        skin.add("default", new BitmapFont());

// Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
        textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
        textButtonStyle.font = skin.getFont("default");

        LabelStyle labStyle = new LabelStyle();
        labStyle.font = skin.getFont("default");
        
        
        skin.add("default", textButtonStyle);
        skin.add("default", labStyle);

// Create a table that fills the screen. Everything else will go inside this table.
        Table backgroundTable = new Table();
        backgroundTable.setFillParent(true);
        backgroundTable.setBackground(skin.newDrawable("white", Color.BLACK));
        stage.addActor(backgroundTable);

// Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
        button = new TextButton("Click me!", skin);
        button1 = new TextButton ("Gather: ", skin);
        foodLabel = new Label ("\n\nFood: " + game.rm.food.displayAmount(), skin);
        
//        backgroundTable.add(button);
        Table t = new Table();
        Table x = new Table();
      //  Table f = new Table ();
        
    //    f.setBackground(skin.newDrawable("white", Color.GREEN));
        x.setBackground(skin.newDrawable("white", Color.GREEN));
        t.setBackground(skin.newDrawable("white", Color.BLUE));
        backgroundTable.add(t).height(stage.getHeight()).width(100).left();
        
        t.add(button);
//        backgroundTable.row();
        backgroundTable.add(x).expandX().width(300).height(90);
     //   backgroundTable.add(f).expandX().width(300).height(height)
        x.add (button1);
        x.add (foodLabel);
        backgroundTable.row();

// Add a listener to the button. ChangeListener is fired when the button's checked state changes, eg when clicked,
// Button#setChecked() is called, via a key press, etc. If the event.cancel() is called, the checked state will be reverted.
// ClickListener could have been used, but would only fire when clicked. Also, canceling a ClickListener event won't
// revert the checked state.
        button.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Clicked! Is checked: " + button.isChecked());
                button1.setText("Gather: " + button.isChecked());
            }
        }
        );
        
        button1.addListener(new ClickListener() {
        	
        	@Override
        	public void clicked (InputEvent event, float x, float y){
        		game.rm.ClickMultiplierUpdater(game.pm, game.rm.food.getGatherMultiplier());
                game.rm.ClickFood(0, game.pm, game.bm);
                foodLabel.setText("\n\nFood: " + game.rm.food.displayAmount());
        	}
        });

// Add an image actor. Have to set the size, else it would be the size of the drawable (which is the 1x1 texture).
        backgroundTable.add(new Image(skin.newDrawable("white", Color.RED))).size(64);
        backgroundTable.debug();
    }

    public void render() {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

     //   Table.drawDebug(stage);
     //   button.setText(Float.toString(Gdx.graphics.getWidth()));
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}

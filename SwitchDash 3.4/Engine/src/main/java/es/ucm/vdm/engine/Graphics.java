package es.ucm.vdm.engine;

import es.ucm.vdm.engine.utils.Rect;

public interface Graphics {

    public Pixmap newPixmap(String fileName);

    public void clear(int color);

    public void fillRect(Rect rect, int color);

    public void drawPixmap(Pixmap pixmap, int x, int y);

    public void drawPixmap(Pixmap pixmap, Rect src, int x, int y);

    public void drawPixmap(Pixmap pixmap, Rect src, Rect dst, float alpha);

    public int getWidth();
    public int getHeight();

}

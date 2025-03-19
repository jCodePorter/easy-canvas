package com.augrain.easy.canvas.element.basic;

import com.augrain.easy.canvas.element.AbstractDimensionElement;
import com.augrain.easy.canvas.element.IElement;
import com.augrain.easy.canvas.enums.ZoomMode;
import com.augrain.easy.canvas.geometry.CoordinatePoint;
import com.augrain.easy.canvas.geometry.Dimension;
import com.augrain.easy.canvas.utils.ImageUtils;
import lombok.Getter;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 图片元素
 *
 * @author biaoy
 * @since 2025/02/20
 */
@Getter
public class ImageElement extends AbstractDimensionElement implements IElement {
    /**
     * 输入的图片对象
     */
    private BufferedImage image;

    public ImageElement(BufferedImage image) {
        this.image = image;
        handleDimension();
    }

    private void handleDimension() {
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    /**
     * @param httpUrl 图片url
     */
    public ImageElement(String httpUrl) {
        this.image = ImageUtils.loadUrl(httpUrl);
        handleDimension();
    }

    public ImageElement scale(int width, int height, ZoomMode zoomMode) {
        this.image = ImageUtils.scale(image, width, height, zoomMode);
        handleDimension();
        return this;
    }

    public ImageElement rotate(int angel) {
        this.image = ImageUtils.rotate(image, angel);
        handleDimension();
        return this;
    }

    @Override
    public CoordinatePoint doRender(Graphics2D g, Dimension dimension, int canvasWidth, int canvasHeight) {
        CoordinatePoint point = dimension.getPoint();
        g.drawImage(this.getImage(), point.getX(), point.getY(), dimension.getWidth(), dimension.getHeight(), null);
        return point;
    }
}

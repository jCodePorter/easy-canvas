package com.augrain.easy.canvas.geometry;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 相对位置
 *
 * @author biaoy
 * @since 2025/03/04
 */
@Getter
@Setter
@ToString
public class RelativePosition implements Position {

    /**
     * {@link Positions} 基准位置
     */
    private Position referencePosition;

    /**
     * 边距
     */
    private Margin margin;

    private RelativePosition(Position position, Margin margin) {
        this.referencePosition = position;
        this.margin = margin;
    }

    public static RelativePosition of(Position position) {
        return new RelativePosition(position, Margin.DEFAULT);
    }

    public static RelativePosition of(Position position, Margin margin) {
        return new RelativePosition(position, margin);
    }

    @Override
    public CoordinatePoint calculate(int enclosingWidth, int enclosingHeight, int elementWidth, int elementHeight, Margin margin) {
        return this.referencePosition.calculate(enclosingWidth, enclosingHeight, elementWidth, elementHeight, this.margin);
    }
}

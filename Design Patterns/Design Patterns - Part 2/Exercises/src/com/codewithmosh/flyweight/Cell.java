package com.codewithmosh.flyweight;

public class Cell {
  private final int row;
  private final int column;
  private String content;
  private CellType cellType;
  private CellFactory cellFactory = new CellFactory();

  public Cell(int row, int column) {
    this.row = row;
    this.column = column;
    this.cellType = cellFactory.getCellType("Times New Roman", 12, false);
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  private CellType getCellType() {
    return cellType;
  }

  private void setCellType(CellType cellType) {
    this.cellType = cellType;
  }

  public String getFontFamily() {
    return cellType.getFontFamily();
  }

  public void setFontFamily(String fontFamily) {
    setCellType(cellFactory.getCellType(fontFamily, getFontSize(), isBold()));
  }

  public int getFontSize() {
    return cellType.getFontSize();
  }

  public void setFontSize(int fontSize) {
    setCellType(cellFactory.getCellType(getFontFamily(), fontSize, isBold()));
  }

  public boolean isBold() {
    return cellType.isBold();
  }

  public void setBold(boolean bold) {
    setCellType(cellFactory.getCellType(getFontFamily(), getFontSize(), bold));
  }

  public void render() {
    System.out.printf("(%d, %d): %s [%s]\n", row, column, content, getFontFamily());
  }
}

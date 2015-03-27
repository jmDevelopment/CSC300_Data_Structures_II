package CSC301_HW2;

public interface Boardable
{
  public void setBoardStart(int month,int day, int year);
  public void setBoardEnd(int month,int day, int year);
  public boolean isBoarding(int month,int day, int year);
}


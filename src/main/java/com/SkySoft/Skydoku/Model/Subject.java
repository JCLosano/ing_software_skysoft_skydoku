package com.SkySoft.Skydoku.Model;

import com.SkySoft.Skydoku.view.Observer;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

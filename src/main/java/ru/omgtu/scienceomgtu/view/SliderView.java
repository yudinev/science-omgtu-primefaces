package ru.omgtu.scienceomgtu.view;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.SlideEndEvent;
import org.springframework.context.annotation.Scope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "sliderView")
@Scope("view")
@Getter
@Setter
public class SliderView implements Serializable {

    private int number1 = 50;
    private float number2 = 0.2f;
    private int number3;
    private int number4;
    private int number5;
    private int number6;
    private int number7;
    private int number8 = 30;
    private int number9 = 80;
    public void onInputChanged(ValueChangeEvent event) {
        FacesMessage message = new FacesMessage("Input Changed", "Value: " + event.getNewValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onSlideEnd(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Slide Ended", "Value: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}

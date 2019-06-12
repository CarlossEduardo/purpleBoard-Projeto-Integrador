/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;
  
@ManagedBean(name="GraficoPizzaMB")
public class GraficoPizza implements Serializable {
  
    private PieChartModel pieModel1;
  
    @PostConstruct
    public void init() {
        createPieModels();
    }
  
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
           
    private void createPieModels() {
        createPieModel1();
    }
  
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
          
        pieModel1.set("Carro", 1000);
        pieModel1.set("Ônibus", 600);
        pieModel1.set("Metrô", 1500);
        pieModel1.set("Trem", 700);
        pieModel1.set("Bicicleta", 100);
          
        pieModel1.setTitle("Meio de Transporte");
        pieModel1.setLegendPosition("w");
    }
      
}

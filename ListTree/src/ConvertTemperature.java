import javax.swing.JOptionPane;

public class ConvertTemperature {

    private Float initTemperature = null;

    public ConvertTemperature() {
        Integer originTypeTemperature = this.requestTypeTemperature("à ser convertida");
        Integer nextTypeTemperature = this.requestTypeTemperature("para a qual quer converter");

        this.requestTemperature();

        if (originTypeTemperature == 1 && nextTypeTemperature == 2) {
            this.transformCelsiusInFarenheit();
        } else if (originTypeTemperature == 1 && nextTypeTemperature == 3) {
            this.transformCelsiusInKelvin();
        } else if (originTypeTemperature == 2 && nextTypeTemperature == 1) {
            this.transformFarenheitInCelsius();
        } else if (originTypeTemperature == 2 && nextTypeTemperature == 3) {
            this.transformFarenheitInKelvin();
        } else if (originTypeTemperature == 3 && nextTypeTemperature == 1) {
            this.transformKelvinInCelsius();
        } else if (originTypeTemperature == 3 && nextTypeTemperature == 2) {
            this.transformKelvinInFarenheit();
        }
    }

    private void transformCelsiusInFarenheit() {
        Float farenheit = (9 * this.initTemperature / 5) + 32;
        this.response(farenheit, "Celsius", "Farenheit");
    }

    private void transformCelsiusInKelvin() {
        Float kelvin = this.initTemperature + 273.15f;
        this.response(kelvin, "Celsius", "Kelvin");
    }

    private void transformFarenheitInCelsius() {
        Float celsius = 5 * (this.initTemperature - 32) / 9;
        this.response(celsius, "Farenheit", "Celsius");
    }

    private void transformFarenheitInKelvin() {
        Float kelvin = (this.initTemperature - 32) * 5 / 9 + 273.15f;
        this.response(kelvin, "Farenheit", "Kelvin");
    }

    private void transformKelvinInCelsius() {
        Float kelvin = this.initTemperature - 273.15f;
        this.response(kelvin, "Kelvin", "Celsius");
    }

    private void transformKelvinInFarenheit() {
        Float farenheit = (this.initTemperature - 273.15f) * 9 / 5 + 32;
        this.response(farenheit, "Kelvin", "Farenheit");
    }

    private void response(Float temperature, String initType, String endType) {
        JOptionPane.showMessageDialog(null,
                this.initTemperature + " " + initType + " = " + temperature + " " + endType);
    }

    private void requestTemperature() {
        do {
            try {
                this.initTemperature = Float.parseFloat(JOptionPane.showInputDialog("Informe a temperatura inicial"));
            } catch (Exception e) {
                String[] splitError = e.getMessage().split(",");
                if (splitError.length > 1) {
                    JOptionPane.showMessageDialog(null, "Você deve usar . (ponto) ao invés de , (virgula)");
                } else if (e.getMessage().indexOf("string") > 0) {
                    JOptionPane.showMessageDialog(null,
                            "Provavél que você não tenha digita um numero, tente outra vez");
                }
                System.out.println(e);
            }
        } while (this.initTemperature == null);
    }

    private Integer requestTypeTemperature(String completeString) {
        Integer typeTemperature = 0;
        do {
            try {
                typeTemperature = Integer.parseInt(JOptionPane.showInputDialog(
                        "Informe a temperatura " + completeString + " 1 - Celsius, 2 - Farenheit ou 3 - Kelvin"));
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (typeTemperature <= 0 || typeTemperature >= 4);
        return typeTemperature;
    }

}
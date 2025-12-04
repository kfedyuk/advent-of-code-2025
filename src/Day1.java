import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Day1 {

    private List<String> inputData;
    private int actualPassword;
    private int dial;

    public Day1(String inputData) throws IOException {
        this.inputData = readInput(inputData);
        this.actualPassword = 0;
        this.dial = 50;
    }

    public void decipherPassword1(){
        for(int i = 0; i < inputData.size(); i++){
            String direction = inputData.get(i).substring(0,1);
            int rotationAmount = Integer.parseInt(inputData.get(i).substring(1));
            if(direction.equals("L")){
                this.dial = (this.dial - rotationAmount) % 100;
            }else{
                this.dial = (this.dial + rotationAmount) % 100;;
            }

            if(dial == 0)
                actualPassword++;
        }
    }

    public void decipherPassword2(){
        for(int i = 0; i < inputData.size(); i++){
            String direction = inputData.get(i).substring(0,1);
            int rotationAmount = Integer.parseInt(inputData.get(i).substring(1));
            if(direction.equals("L")){
                if (this.dial == 0)
                    actualPassword += (rotationAmount / 100);
                else if (rotationAmount >= this.dial)
                    actualPassword += 1 + ((rotationAmount - this.dial) / 100);
                this.dial = ((this.dial - rotationAmount) % 100 + 100) % 100;
            }else{
                actualPassword += ((this.dial + rotationAmount) / 100);
                this.dial = ((this.dial + rotationAmount) % 100 + 100) % 100;
            }
        }
    }

    public int getActualPassword() {
        return actualPassword;
    }

    public List<String> readInput(String fileName) throws IOException {
        return  Files.readAllLines(Paths.get(fileName));
    }

}

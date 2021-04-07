import React,{useState} from "react";
import './Calc.css'
import Button from './Button/Button'


const Calc = () => {
    const [value, setValue] = useState("0")
    const [memory, setMemory] = useState(null)
    const [operator, setOperator] = useState(null)
    const handleClick = (content) => () => {
        const num = parseFloat(value);
        if (content === "Clear") {
            setValue("0");
            setMemory(null);
            setOperator(null);
            return;
        }
        if (content === "÷") {
            if (operator !== null) {
                if (operator === "+") {
                    setMemory((memory + parseFloat(value)));
                }
                else if (operator === "-") {
                    setMemory((memory - parseFloat(value)));
                }
                else if (operator === "÷") {
                    setMemory((memory / parseFloat(value)));
                }
            }
                else {
                    setMemory(parseFloat(value))
                }

            setValue("0");
            setOperator("÷");
            return;
        }
        if (content === "-") {
            if (operator !== null) {
                if (operator === "+") {
                    setMemory((memory + parseFloat(value)));
                }
                else if (operator === "-") {
                    setMemory((memory - parseFloat(value)));
                }
                else if (operator === "÷") {
                    setMemory((memory / parseFloat(value)));
                }
            }
                else {
                    setMemory(parseFloat(value))
                }

            setValue("0");
            setOperator("-");
            return;
        }
        if (content === "+") {
            if (operator !== null) {
                if (operator === "+") {
                    setMemory((memory + parseFloat(value)));
                }
                else if (operator === "-") {
                    setMemory((memory - parseFloat(value)));
                }
                else if (operator === "÷") {
                    setMemory((memory / parseFloat(value)));
                }
            }
                else {
                    setMemory(parseFloat(value))
                }

            setValue("0");
            setOperator("+");
            return;
        }
        if (content === "=") {
            if (!operator) return;

            if (operator === "+") {
                setValue((memory + parseFloat(value)).toString());
            }
            else if (operator === "-"){
                setValue((memory - parseFloat(value)).toString());
            }
            else if (operator === "÷"){
                setValue((memory / parseFloat(value)).toString());
            }
            setMemory(null);
            setOperator(null);
            return;
        }
      
        setValue((parseFloat(value) + content).toString());
    };


  return (
      <div className="App">
      <div className="display">{value}</div>
          <div className="buttons">
              <Button onButtonClick={handleClick} content="Clear" type="function" />
              <Button onButtonClick={handleClick} content="÷" type="operator"/>
              <Button onButtonClick={handleClick} content="7" />
              <Button onButtonClick={handleClick} content="8" />
              <Button onButtonClick={handleClick} content="9" />
              <Button onButtonClick={handleClick} content="-" type="operator" />
              <Button onButtonClick={handleClick} content="4" />
              <Button onButtonClick={handleClick} content="5" />
              <Button onButtonClick={handleClick} content="6" />
              <Button onButtonClick={handleClick} content="+" type="operator"/>
              <Button onButtonClick={handleClick} content="1" />
              <Button onButtonClick={handleClick} content="2" />
              <Button onButtonClick={handleClick} content="3" />
              <Button onButtonClick={handleClick} content="=" type="operator"/>
      </div>
    </div>
  );
};

export default Calc;

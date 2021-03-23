export function groupbyvalue(inputArray) {
    if (!Array.isArray(inputArray)) {
        return;
    }
    console.log("An Array");


    // pass a function to map
    const map1 = Object.entries(inputArray).reduce((accumulator, entry) => {
        console.log("accumulator", accumulator);
        if (accumulator[entry.caseType] !== undefined) {
            console.log("exists", accumulator[entry.caseType]);
            //accumulator[entry.caseType].count++;
        } else {
            console.log("doesn't exist", accumulator);
            // accumulator = {...accumulator, }
            // accumulator[""] =  {count: 1, caseType: entry.caseType }
        }

        return accumulator;
    });


    console.log(map1);



    /*
    return inputArray.map(input => {
        return Object.entries(input).reduce((accumulator, currentEntry) => {
            function processEntry(current) {
                // check if Object
                if (typeof current === "object" && !Array.isArray(current)) {
                    // assuming object has only 2 properties
                    const { value, ...other } = current;
                    const [key] = Object.values(other);
                    accumulator[key] = value;
                    return;
                }
                const [currentKey, currentValue] = current;
                if (Array.isArray(currentValue)) {
                    currentValue.forEach(obj => processEntry(obj));
                } else {
                    accumulator[currentKey] = currentValue;
                }
            }
            processEntry(currentEntry);
            return accumulator;
        }, {});
    });
    */
}

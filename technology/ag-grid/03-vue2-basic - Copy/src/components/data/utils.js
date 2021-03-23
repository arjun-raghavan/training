export function transformData(inputArray) {
    if (!Array.isArray(inputArray)) {
        return;
    }

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
}

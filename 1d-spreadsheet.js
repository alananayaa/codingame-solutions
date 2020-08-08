/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
let values = []
let operations = []

const getCellValue = index => {
    if (values[index]){
        return values[index]
    }

    const arg1 = operations[index].arg1
    const arg2 = operations[index].arg2

    const val1 = arg1.includes('$') ? getCellValue(parseInt(arg1.slice(1))) : parseInt(arg1)
    const val2 = arg2.includes('_') ? 0 : arg2.includes('$') ? getCellValue(parseInt(arg2.slice(1))) : parseInt(arg2)

    switch (operations[index].operation) {
        case 'VALUE':
            values[index] = parseInt(val1)
            break
        
        case 'ADD':
            values[index] = parseInt(val1 + val2)
            break
        
        case 'SUB':
            values[index] = parseInt(val1 - val2)
            break

        case 'MULT':
            values[index] = parseInt(val1 * val2)
            break
    
        default:
            break
    }
    
    return values[index]
}


const N = parseInt(readline());
for (let i = 0; i < N; i++) {
    var inputs = readline().split(' ');
    const operation = inputs[0];
    const arg1 = inputs[1];
    const arg2 = inputs[2];
    
    operations.push({
        operation: operation, 
        arg1: arg1, 
        arg2: arg2
    })
}
for (let i = 0; i < N; i++) {
    console.log(getCellValue(i))
}

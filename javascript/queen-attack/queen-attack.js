export class QueenAttack {

    constructor(
        {white=[0, 3], black=[7, 3]} 
        = {white:[0, 3], black:[7, 3]}) {

        if (white[0] === black[0] && white[1] === black[1])
            throw new Error('Queens cannot share the same space');
        
        this.white = white;
        this.black = black;
        this.setupBoard();
    }

    setupBoard() {
        this.board =    
        [   ['_', '_', '_', '_', '_', '_', '_', '_'],
            ['_', '_', '_', '_', '_', '_', '_', '_'],
            ['_', '_', '_', '_', '_', '_', '_', '_'],
            ['_', '_', '_', '_', '_', '_', '_', '_'],
            ['_', '_', '_', '_', '_', '_', '_', '_'],
            ['_', '_', '_', '_', '_', '_', '_', '_'],
            ['_', '_', '_', '_', '_', '_', '_', '_'],
            ['_', '_', '_', '_', '_', '_', '_', '_']    ];

        this.board[this.white[0]][this.white[1]] = 'W';
        this.board[this.black[0]][this.black[1]] = 'B';
    }

    toString() {
        return this.board.map(arr => arr.join(' ')).join('\n') + '\n';
    }

    canAttack() {
        const { white, black } = this;
        return white[0] === black[0]  // Same row
            || white[1] === black[1]  // Same column
            // Same nw-se diagonal
            || white[0] - white[1] === black[0] - black[1]
            // Same ne-sw diagonal
            || white[0] + white[1] === black[0] + black[1];
    }
}

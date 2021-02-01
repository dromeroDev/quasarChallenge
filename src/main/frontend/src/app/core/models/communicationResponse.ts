import { Position } from "./position";

export class CommunicationResponse {
    private message: string;
    private position: Position;

    constructor(message: string, position: number[]) {
        this.message = message;
        this.position = new Position(position[0], position[1]);
    }
}
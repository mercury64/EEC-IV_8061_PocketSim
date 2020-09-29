package ca.nerret.emu.emulator.opcodes;

import ca.nerret.emu.emulator.AddressMode;
import ca.nerret.emu.emulator.OpCode;
import ca.nerret.emu.emulator.ProgramStatusWord;
import ca.nerret.emu.emulator.State;

/**
 * @author h
 */
public class OpCodeCMPW extends OpCode implements IOpCode {

    public OpCodeCMPW(int opcode, String mnemonic) {
		super(opcode, mnemonic);
		// TODO Auto-generated constructor stub
	}

	@Override
    public final void exec(State state_) {
        int[] memory = state_.getMemory();
        final int pc = state_.getPc();

        byte[] operands;
        int numberOfBytes = 0;
        int stateTime = 0;

        switch (this.getAddressModeInt())
        {
	        case AddressMode.DIRECT:
	        	numberOfBytes = 3;
	        	stateTime = 4;
	        	break;
	        case AddressMode.IMMEDIATE:
	        	numberOfBytes = 4;
	        	stateTime = 5; 
	        	break;
	        case AddressMode.INDIRECT:
	        	numberOfBytes = 3;
	        	stateTime = 6;
	        	break;
	        case AddressMode.SHORT_INDEXED:
	        	numberOfBytes = 4;
	        	stateTime = 6;
	        	break;	
        }
        state_.setPc(pc + numberOfBytes);
        state_.updateStateTime(stateTime);
        
        operands = new byte[numberOfBytes];
        for (int i = 0; i < numberOfBytes; i++) {
			operands[i] = (byte)memory[pc + i];
		}
        
        /*
         * 9b,ee,80,42         cmpb  R42,[Ree+80] 
         * 1001 1011, 1110 1110, 1000 0000, 0100 0010
         * Short Indexed
         * Ree = 0x0780 or 80, 07
         * 80 = 1000 0000 
         * ***  ^ is negative!!!
         * this is for CMPB, should be similar for CMPW
         */
        // Handle negative
        //if ( ((byte1 & 0x4) >> 2) == 1)
        //{
        	// ~ compliment
        	// ~0x03ff = 0000 0011 1111 1111
        	// ........= 1111 1100 0000 0000
        	//
        	//offset = offset | ~0x03ff;
       // }
        	
        	
        // LSB
        // second byte, shift to high word position
        // first byte, mask to low word position
    	short RA = (short) (operands[2] << 8 |   operands[1] & 0xff);
		short RB = state_.getWordRegister(operands[numberOfBytes-1]);
   
    	// TODO:  Need to implement compare, and setting of PSW!!!
    	
		int compare = Short.compare(RB, RA  );
		
		// do_sub(reg_r16(OP2), OP1);
		//state_.doSub((short) state_.setWordRegister(RB), RA);
		state_.doSub( RB, RA);
		
		  System.out.println(compare);
    	  System.out.println(" Compare: (" + String.format("0x%04X", RB) + ", "+ String.format("0x%04X", RA) + ")");

		  
		if ( RB < RA)
		{

			state_.setPswBit(ProgramStatusWord.CARRY, false);
			

		}
		else
		{

			//state_.setPswBit(ProgramStatusWord.ZERO, true);
			//state_.setPswBit(ProgramStatusWord.NEGATIVE, true);
			//state_.setPswBit(ProgramStatusWord.OVERFLOW, true);
			//state_.setPswBit(ProgramStatusWord.OVERFLOW_TRAP, true);
			state_.setPswBit(ProgramStatusWord.CARRY, true);
			//state_.setPSW(ProgramStatusWord.STICKY_BIT, null);
		}

    }
}
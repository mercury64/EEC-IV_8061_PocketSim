package ca.nerret.emu.emulator;

import java.util.HashMap;
import java.util.Map;

import ca.nerret.emu.emulator.opcodes.IOpCode;
import ca.nerret.emu.emulator.opcodes.OpCode06;
import ca.nerret.emu.emulator.opcodes.OpCodeCLRB;
import ca.nerret.emu.emulator.opcodes.OpCodeCLRW;
import ca.nerret.emu.emulator.opcodes.OpCodeCMPB;
import ca.nerret.emu.emulator.opcodes.OpCodeCMPW;
import ca.nerret.emu.emulator.opcodes.OpCodeSCALL;
import ca.nerret.emu.emulator.opcodes.OpCodeSJMP;
import ca.nerret.emu.emulator.opcodes.OpCodeSTB;
import ca.nerret.emu.emulator.opcodes.OpCodeSTW;
import ca.nerret.emu.emulator.opcodes.OpCode31;
import ca.nerret.emu.emulator.opcodes.OpCodeAD3W;
import ca.nerret.emu.emulator.opcodes.OpCodeAN3B;
import ca.nerret.emu.emulator.opcodes.OpCodeC3;
import ca.nerret.emu.emulator.opcodes.OpCodeCD;
import ca.nerret.emu.emulator.opcodes.OpCodeDI;
import ca.nerret.emu.emulator.opcodes.OpCodeFF;
import ca.nerret.emu.emulator.opcodes.OpCodeINCB;
import ca.nerret.emu.emulator.opcodes.OpCodeJE;
import ca.nerret.emu.emulator.opcodes.OpCodeJNC;
import ca.nerret.emu.emulator.opcodes.OpCodeJNE;
import ca.nerret.emu.emulator.opcodes.OpCodeLDB;
import ca.nerret.emu.emulator.opcodes.OpCodeLDW;
import ca.nerret.emu.emulator.opcodes.OpCodeNop;

public final class OpcodeCache {

    private static final Map<Integer, IOpCode> _OPCODES = new HashMap<>();
    
    static {
        
        _OPCODES.put(0x00, new OpCodeNop(0x00, "SKP"));

        _OPCODES.put(0x11, new OpCodeCLRB(0x11, "CLRB"));
        _OPCODES.put(0x01, new OpCodeCLRW(0x01, "CLRW"));
        
        _OPCODES.put(0x20, new OpCodeSJMP(0x20, "SJMP"));
        _OPCODES.put(0x21, new OpCodeSJMP(0x21, "SJMP"));
        _OPCODES.put(0x22, new OpCodeSJMP(0x22, "SJMP"));
        _OPCODES.put(0x23, new OpCodeSJMP(0x23, "SJMP"));
        _OPCODES.put(0x24, new OpCodeSJMP(0x24, "SJMP"));
        _OPCODES.put(0x25, new OpCodeSJMP(0x25, "SJMP"));
        _OPCODES.put(0x26, new OpCodeSJMP(0x26, "SJMP"));
        _OPCODES.put(0x27, new OpCodeSJMP(0x27, "SJMP"));
        
        _OPCODES.put(0x28, new OpCodeSCALL(0x28, "SCALL"));
        _OPCODES.put(0x29, new OpCodeSCALL(0x29, "SCALL"));
        _OPCODES.put(0x2a, new OpCodeSCALL(0x2a, "SCALL"));
        _OPCODES.put(0x2b, new OpCodeSCALL(0x2b, "SCALL"));
        _OPCODES.put(0x2c, new OpCodeSCALL(0x2c, "SCALL"));
        _OPCODES.put(0x2d, new OpCodeSCALL(0x2d, "SCALL"));
        _OPCODES.put(0x2e, new OpCodeSCALL(0x2e, "SCALL"));
        _OPCODES.put(0x2f, new OpCodeSCALL(0x2f, "SCALL"));


        _OPCODES.put(0x17, new OpCodeINCB(0x17, "INCB"));
        
        _OPCODES.put(0xFA, new OpCodeDI(0xfa, "DI"));
        _OPCODES.put(0xFF, new OpCodeFF(0xff, "NOP"));
 
        _OPCODES.put(0x98, new OpCodeCMPB(0x98, "CMPB"));
        _OPCODES.put(0x99, new OpCodeCMPB(0x99, "CMPB"));
        _OPCODES.put(0x9a, new OpCodeCMPB(0x9a, "CMPB"));
        _OPCODES.put(0x9b, new OpCodeCMPB(0x9b, "CMPB"));
        
        _OPCODES.put(0x88, new OpCodeCMPW(0x88, "CMPW"));
        _OPCODES.put(0x89, new OpCodeCMPW(0x89, "CMPW"));
        _OPCODES.put(0x8a, new OpCodeCMPW(0x8a, "CMPW"));
        _OPCODES.put(0x8b, new OpCodeCMPW(0x8b, "CMPW"));
        
        _OPCODES.put(0x44, new OpCodeAD3W(0x44, "AD3W"));
        _OPCODES.put(0x45, new OpCodeAD3W(0x45, "AD3W"));
        _OPCODES.put(0x46, new OpCodeAD3W(0x46, "AD3W"));
        _OPCODES.put(0x47, new OpCodeAD3W(0x47, "AD3W"));
        
        _OPCODES.put(0x50, new OpCodeAN3B(0x50, "AN3B"));
        _OPCODES.put(0x51, new OpCodeAN3B(0x51, "AN3B"));
        _OPCODES.put(0x52, new OpCodeAN3B(0x52, "AN3B"));
        _OPCODES.put(0x53, new OpCodeAN3B(0x53, "AN3B"));
                        
        _OPCODES.put(0xB0, new OpCodeLDB(0xb0, "LDB"));
        _OPCODES.put(0xB1, new OpCodeLDB(0xb1, "LDB"));
        _OPCODES.put(0xB2, new OpCodeLDB(0xb2, "LDB"));
        _OPCODES.put(0xB3, new OpCodeLDB(0xb3, "LDB"));
        
        _OPCODES.put(0xA0, new OpCodeLDW(0xa0, "LDW"));
        _OPCODES.put(0xA1, new OpCodeLDW(0xa1, "LDW"));
        _OPCODES.put(0xA2, new OpCodeLDW(0xa2, "LDW"));
        _OPCODES.put(0xA3, new OpCodeLDW(0xa3, "LDW"));
        
        _OPCODES.put(0xC4, new OpCodeSTB(0xc4, "STB"));
        _OPCODES.put(0xC6, new OpCodeSTB(0xc6, "STB"));
        _OPCODES.put(0xC7, new OpCodeSTB(0xc7, "STB"));
        
        _OPCODES.put(0xC0, new OpCodeSTW(0xc0, "STW"));
        _OPCODES.put(0xC2, new OpCodeSTW(0xc2, "STW"));
        _OPCODES.put(0xC3, new OpCodeSTW(0xc3, "STW"));
        
        _OPCODES.put(0xD3, new OpCodeJNC(0xd3, "JNC"));
        _OPCODES.put(0xD7, new OpCodeJNE(0xd7, "JNE"));
        _OPCODES.put(0xDF, new OpCodeJE(0xdf, "JE"));
        _OPCODES.put(0xDB, new OpCodeJE(0xdb, "JC"));

    }

    private OpcodeCache() { 
    	
    	// 
    }

    /**
     * Get the IOPcode for the current instruction.
     * @param instruction_ Where the state machine pc is at.
     * @return the IOpcode
     */
    public static IOpCode get(int instruction_) {
    	
    	int opCode = instruction_;
    	
    	IOpCode opc = _OPCODES.get(opCode);
    	
        try 
        {
            opc.setAddressMode(new AddressMode((byte)instruction_));
    	}
        catch(Exception e)
        {
            System.err.println("OPCODE Not found: " + String.format("0x%02X: ", opCode));

            return null;
        }
        return opc;
    }
}

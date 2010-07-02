/*
Copyright (c) 2008~2009, Justin R. Bengtson (poopshotgun@yahoo.com)
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice,
        this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice,
        this list of conditions and the following disclaimer in the
        documentation and/or other materials provided with the distribution.
    * Neither the name of Justin R. Bengtson nor the names of contributors may
        be used to endorse or promote products derived from this software
        without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package states;

import common.CommonTools;
import components.AvailableCode;
import components.Engine;
import components.Mech;
import components.MechModifier;

public class stEngineICE implements ifEngine, ifState {
    // An Inner Sphere I.C.E. Engine
    private final static AvailableCode AC = new AvailableCode( AvailableCode.TECH_BOTH ),
                                       LARGE_AC = new AvailableCode( AvailableCode.TECH_BOTH );
    private final static double[] Masses = { 1.0,1.0,1.0,1.0,2.0,2.0,2.0,
        2.0,3.0,3.0,3.0,4.0,4.0,4.0,5.0,5.0,6.0,6.0,6.0,7.0,7.0,
        8.0,8.0,8.0,9.0,9.0,10.0,10.0,11.0,11.0,12.0,12.0,12.0,
        14.0,14.0,15.0,15.0,16.0,17.0,17.0,18.0,19.0,20.0,20.0,21.0,
        22.0,23.0,24.0,25.0,26.0,27.0,28.0,29.0,31.0,32.0,33.0,35.0,
        36.0,38.0,39.0,41.0,43.0,45.0,47.0,49.0,51.0,54.0,57.0,59.0,
        63.0,66.0,69.0,73.0,77.0,82.0,87.0,92.0,98.0,105.0,113.0,
        122.0,133.0,145.0,159.0,175.0,194.0,215.0,239.0,267.0,300.0,
        337.0,380.0,429.0,486.0,551.0,626.0,712.0,811.0,925.0};
    private final static int[] BFStructure = {1,1,2,2,3,3,3,4,4,5,5,5,6,6,6,7,7,8,8};
    private Engine Owner;

    public stEngineICE( Engine e ) {
        AC.SetISCodes( 'C', 'A', 'A', 'A' );
        AC.SetISDates( 0, 0, false, 1950, 0, 0, false, false );
        AC.SetISFactions( "", "", "PS", "" );
        AC.SetCLCodes( 'C', 'X', 'A', 'A' );
        AC.SetCLDates( 0, 0, false, 1950, 0, 0, false, false );
        AC.SetCLFactions( "", "", "PS", "" );
        AC.SetRulesLevels( AvailableCode.RULES_ADVANCED, AvailableCode.RULES_TOURNAMENT, AvailableCode.RULES_TOURNAMENT, AvailableCode.RULES_UNALLOWED, AvailableCode.RULES_TOURNAMENT );
        LARGE_AC.SetISCodes( 'C', 'A', 'A', 'A' );
        LARGE_AC.SetISDates( 2550, 2630, true, 2630, 0, 0, false, false );
        LARGE_AC.SetISFactions( "PS", "PS", "", "" );
        LARGE_AC.SetCLCodes( 'C', 'X', 'A', 'A' );
        LARGE_AC.SetCLDates( 2550, 2630, true, 2630, 0, 0, false, false );
        LARGE_AC.SetCLFactions( "PS", "PS", "", "" );
        LARGE_AC.SetRulesLevels( AvailableCode.RULES_EXPERIMENTAL, AvailableCode.RULES_EXPERIMENTAL, AvailableCode.RULES_EXPERIMENTAL, AvailableCode.RULES_EXPERIMENTAL, AvailableCode.RULES_EXPERIMENTAL );
        Owner = e;
    }

    public boolean HasCounterpart() {
        return false;
    }

    public double GetTonnage( int Rating, boolean fractional ) {
        return Masses[GetIndex( Rating )];
    }
    
    public int GetCTCrits() {
        return 3;
    }
    
    public int GetSideTorsoCrits() {
        return 0;
    }
    
    public int NumCTBlocks() {
        return 2;
    }

    public int NumCVSpaces() {
        return 0;
    }

    public int LargeCVSpaces() {
        return 1;
    }

    public boolean CanSupportRating( int rate, Mech m ) {
        if( CommonTools.IsAllowed( LARGE_AC, m ) ) {
            if( rate < 5 || rate > 500 || rate % 5 != 0 ) {
                return false;
            } else {
                return true;
            }
        } else {
            if( rate < 5 || rate > 400 || rate % 5 != 0 ) {
                return false;
            } else {
                return true;
            }
        }
    }

    public String ActualName() {
        return "Internal Combustion Engine";
    }

    public String CritName() {
        return "I.C.E. Engine";
    }

    public String LookupName() {
        return "I.C.E. Engine";
    }

    public String ChatName() {
        return "ICE";
    }

    public String MegaMekName( boolean UseRear ) {
        return "I.C.E.";
    }

    public String BookReference() {
        return "Tech Manual";
    }

    public double GetCost( int MechTonnage, int Rating ) {
        return ( 1250.0f * ((double) MechTonnage) * ((double) Rating )) / 75.0f;
    }
    
    public AvailableCode GetAvailability() {
        if( Owner.GetRating() > 400 ) { return LARGE_AC; }
        return AC;
    }

    public int FreeHeatSinks() {
        return 0;
    }

    public double GetBVMult() {
        return 1.0f;
    }
    
    public boolean IsFusion() {
        return false;
    }

    public boolean IsNuclear() {
        return false;
    }

    public int GetFullCrits() {
        return 6;
    }

    private int GetIndex( int Rating ) {
        return Rating / 5 - 2;
    }

    private int GetBFIndex( int tonnage ) {
        return (tonnage - 10) / 5;
    }

    public int GetBFStructure( int tonnage ) {
        return BFStructure[GetBFIndex(tonnage)];
    }
    
    public int MaxMovementHeat() {
        return 0;
    }

    public int MinimumHeat() {
        return 0;
    }

    public int JumpingHeatMultiplier() {
        return 1;
    }

    public MechModifier GetMechModifier() {
        return null;
    }

    public boolean IsPrimitive() {
        return false;
    }

    @Override
    public String toString() {
        return "I.C.E. Engine";
    }
}

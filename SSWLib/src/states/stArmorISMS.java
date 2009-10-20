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

import components.*;

public class stArmorISMS implements ifArmor, ifState {
    private final static AvailableCode AC = new AvailableCode( AvailableCode.TECH_INNER_SPHERE );

    public stArmorISMS() {
        AC.SetISCodes( 'D', 'C', 'C', 'C' );
        AC.SetISDates( 0, 0, false, 2470, 0, 0, false, false );
        AC.SetISFactions( "", "", "TH", "" );
        AC.SetRulesLevels( AvailableCode.RULES_TOURNAMENT, AvailableCode.RULES_TOURNAMENT, AvailableCode.RULES_TOURNAMENT, AvailableCode.RULES_TOURNAMENT, AvailableCode.RULES_TOURNAMENT );
    }

    public String GetLookupName() {
        return "Standard Armor";
    }

    public String GetCritName() {
        return "Standard";
    }

    public String GetMMName() {
        return "Standard Armor";
    }

    public int NumCrits() {
        return 0;
    }

    public int GetCVSpace() {
        return 0;
    }

    public float GetAVMult() {
        return 1.0f;
    }

    public float GetFractionalMult() {
        return 0.0625f;
    }

    public boolean IsStealth() {
        return false;
    }

    public float GetCostMult() {
        return 10000.0f;
    }

    public float GetBVTypeMult() {
        return 1.0f;
    }

    public int GetBAR() {
        return 10;
    }

    public MechModifier GetMechModifier() {
        return null;
    }

    public AvailableCode GetAvailability() {
        return AC;
    }
}

/*
Copyright (c) 2010, Justin R. Bengtson (poopshotgun@yahoo.com)
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

package components;

import java.util.Vector;

public class CVLoadout {
    private CombatVehicle Owner;
    private CVLoadout BaseLoadout = null;
    private String Name = "",
                   Source = "";
    private Vector<abPlaceable> Queue = new Vector<abPlaceable>(),
                                FrontItems = new Vector<abPlaceable>(),
                                LeftItems = new Vector<abPlaceable>(),
                                RightItems = new Vector<abPlaceable>(),
                                RearItems = new Vector<abPlaceable>(),
                                Turret1Items = new Vector<abPlaceable>(),
                                RotorItems = new Vector<abPlaceable>(),
                                Turret2Items = new Vector<abPlaceable>(),
                                BodyItems = new Vector<abPlaceable>(),
                                NonCore = new Vector<abPlaceable>(),
                                TCList = new Vector<abPlaceable>();
    private boolean UseAIVFCS = false,
                    UseAVFCS = false,
                    UseApollo = false,
                    Use_TC = false,
                    UsingClanCASE = false,
                    YearSpecified = false,
                    YearRestricted = false;
    //private TargetingComputer CurTC = new TargetingComputer( this, false );
    private int RulesLevel = AvailableCode.RULES_TOURNAMENT,
                TechBase = AvailableCode.TECH_INNER_SPHERE,
                Era = AvailableCode.ERA_STAR_LEAGUE,
                Year = 2750;

    public CVLoadout( CombatVehicle c ) {
        Owner = c;
    }

    public CombatVehicle GetOwner() {
        return Owner;
    }
}
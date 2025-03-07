/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

#include "frc/smartdashboard/SendableChooserBase.h"

#include "frc/smartdashboard/SendableRegistry.h"

using namespace frc;

std::atomic_int SendableChooserBase::s_instances{0};

SendableChooserBase::SendableChooserBase() : m_instance{s_instances++} {
  SendableRegistry::GetInstance().Add(this, "SendableChooser", m_instance);
}

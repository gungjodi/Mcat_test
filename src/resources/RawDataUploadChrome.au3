#Region ;**** Directives created by AutoIt3Wrapper_GUI ****
#AutoIt3Wrapper_UseX64=n
#EndRegion ;**** Directives created by AutoIt3Wrapper_GUI ****
; Wait 10 seconds for the Upload window to appear
  Sleep(1000)
; Set input focus to the edit control of Upload window using the handle returned by WinWait
  ControlFocus("Open","","Edit1")
  Sleep(1000)
; Set the File name text on the Edit field
  ControlSetText("Open", "", "Edit1", @WorkingDir & "\src\resources\Raw Data.xlsx")
  Sleep(1000)
; Click on the Open button
  ControlClick("Open", "","Button1");
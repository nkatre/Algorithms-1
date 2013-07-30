#!/bin/sh
#
# Kernel USB hotplug params include:
#	ACTION=%s [add or remove]
# And if usbdevfs is configured, also:
#	DEVICE=/proc/bus/usb/%03d/%03d
#
# See /etc/hotplug/usb.agent for more information
#-------------------------------------------------------------
# infos de /proc/bus/usb/devices :
#
# T:  Bus=04 Lev=01 Prnt=01 Port=00 Cnt=01 Dev#= 39 Spd=12  MxCh= 0
# D:  Ver= 2.00 Cls=00(>ifc ) Sub=00 Prot=00 MxPS= 8 #Cfgs=  1
# P:  Vendor=0694 ProdID=0002 Rev= 0.00
# S:  SerialNumber=001653040C04
# C:* #Ifs= 1 Cfg#= 1 Atr=c0 MxPwr=  0mA
# I:  If#= 0 Alt= 0 #EPs= 2 Cls=ff(vend.) Sub=ff Prot=ff Driver=(none)
# E:  Ad=01(O) Atr=02(Bulk) MxPS=  64 Ivl=0ms
# E:  Ad=82(I) Atr=02(Bulk) MxPS=  64 Ivl=0ms

#
cd /etc/hotplug

LOGF=/tmp/lego_usb.log

echo -e "#$0 logfile;\nname: $LOGF\n#See /etc/hotplug/usb/wibu_usb.sh" > $LOGF
case $ACTION in
   add)
#        echo "#add: chmod 666 $DEVICE :\$PRODUCT=$PRODUCT:" Mon Nov  6 16:17:27 CET 2006 >> $LOGF
        echo "#add: chmod 666 $DEVICE :\$PRODUCT=$PRODUCT:" >> $LOGF
        /bin/chmod 666 "$DEVICE"
        ;;
   remove)
#        echo "#remove:chmod 666 $DEVICE :\$PRODUCT=$PRODUCT:" Mon Nov  6 16:17:27 CET 2006 >> $LOGF
        echo "#remove:chmod 666 $DEVICE :\$PRODUCT=$PRODUCT:" >> $LOGF
        ;;
esac

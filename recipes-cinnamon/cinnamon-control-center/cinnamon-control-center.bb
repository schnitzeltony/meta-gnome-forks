SUMMARY = "A collection of configuration plugins used in cinnamon-settings"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=75859989545e37968a99b631ef42722e"

DEPENDS = " \
    colord \
    libgnomekbd \
    libxklavier \
    libnotify \
    iso-codes \
    polkit \
    libnma \
    modemmanager \
    pulseaudio \
    gnome-online-accounts \
    cinnamon-desktop \
    cinnamon-menus \
"
inherit meson pkgconfig features_check gtk-icon-cache gettext gsettings

REQUIRED_DISTRO_FEATURES += "polkit pulseaudio x11"

SRC_URI = "git://github.com/linuxmint/cinnamon-control-center.git;branch=master;protocol=https"
SRCREV = "30728a0a142ac0deffde5267263c3b345f1c6556"
PV = "5.2.1+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OEMESON += " \
    -Dwacom=false \
"

FILES:${PN} += "${libdir}/cinnamon-control-center-1/panels"

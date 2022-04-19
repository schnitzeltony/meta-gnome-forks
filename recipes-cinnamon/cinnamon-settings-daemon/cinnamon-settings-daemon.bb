SUMMARY = "The settings daemon for the Cinnamon desktop"
LICENSE = "GPL-2.0-only & LGPL-2.1-only"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552 \
    file://COPYING.LIB;md5=fbc093901857fcd118f065f900982c24 \
"

DEPENDS = " \
    dbus-glib-native \
    colord \
    cups \
    cinnamon-desktop \
    libcanberra \
    fontconfig \
    libgnomekbd \
    libgudev \
    libnotify \
    nss \
    polkit \
    pulseaudio \
    upower \
    libxklavier \
    virtual/libx11 \
    librsvg \
"

# all these are mandatory
REQUIRED_DISTRO_FEATURES = "x11 polkit pulseaudio systemd gobject-introspection-data"
GIR_MESON_OPTION = ""

inherit meson pkgconfig gobject-introspection gtk-icon-cache gsettings

SRC_URI = "git://github.com/linuxmint/cinnamon-settings-daemon.git;branch=master;protocol=https"
SRCREV = "3e820059b5d7faf4e363efa5becb17d0e8526811"
PV = "5.2.0+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OEMESON += " \
    -Duse_wacom=disabled \
"

FILES:${PN} += " \
    ${datadir}/cinnamon-settings-daemon-3.0 \
    ${datadir}/dbus-1 \
    ${datadir}/polkit-1 \
    ${libdir}/cinnamon-settings-daemon-3.0/libcsd.so \
"

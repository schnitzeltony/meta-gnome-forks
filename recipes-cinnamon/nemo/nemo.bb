SUMMARY = "File browser for Cinnamon"
LICENSE = "GPL-2.0-only & GFDL-1.1 & LGPL-2.0-only"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=9e36112c2402ab6d70f4ce15a3d1db1c \
    file://COPYING-DOCS;md5=f9ddfedca2259f421b846d4915d01237 \
    file://COPYING.LIB;md5=86049f0083127688c0f4e429a05fd85f \
"

DEPENDS = " \
    intltool-native \
    gtk+3 \
    pango \
    cinnamon \
    virtual/libx11 \
    libxapp \
    libexif \
    libgsf \
    gvfs \
    eject \
"

inherit meson pkgconfig gobject-introspection gtk-icon-cache gsettings gettext mime mime-xdg features_check

REQUIRED_DISTRO_FEATURES = "x11"

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES += "gobject-introspection-data"
GIR_MESON_OPTION = ""

SRC_URI = "git://github.com/linuxmint/nemo.git;branch=master;protocol=https"
SRCREV = "214131ed02c66ba18d873e34ec9b3d50c5c6988d"
PV = "5.2.4+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OEMESON += "-Dxmp=false"

FILES:${PN} += " \
    ${datadir}/gtksourceview-* \
    ${datadir}/mime \
    ${datadir}/dbus-1 \
    ${datadir}/polkit-1 \
"

RDEPENDS:${PN} += " \
   gvfs gvfsd-ftp gvfsd-sftp gvfsd-trash \
   python3-core \
   python3-xlrd \
"
